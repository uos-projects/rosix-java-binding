package com.uros.rosix.core;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * ROSIX 核心接口
 * 提供资源管理的基础操作，类似 POSIX 的文件操作
 */
public interface ROSIX {
    
    /**
     * 打开或创建资源引用
     * 
     * @param uri 资源 URI (例如: "sensor://temperature/room1")
     * @param mode 访问模式
     * @return 资源句柄
     * @throws ROSIXException 如果操作失败
     */
    ResourceHandle open(String uri, OpenMode mode) throws ROSIXException;
    
    /**
     * 关闭资源句柄并释放相关资源
     * 
     * @param handle 要关闭的资源句柄
     * @throws ROSIXException 如果操作失败
     */
    void close(ResourceHandle handle) throws ROSIXException;
    
    /**
     * 从资源读取数据
     * 
     * @param handle 资源句柄
     * @param buffer 存储读取数据的缓冲区
     * @return 实际读取的字节数
     * @throws ROSIXException 如果操作失败
     */
    int read(ResourceHandle handle, byte[] buffer) throws ROSIXException;
    
    /**
     * 向资源写入数据
     * 
     * @param handle 资源句柄
     * @param data 要写入的数据
     * @return 实际写入的字节数
     * @throws ROSIXException 如果操作失败
     */
    int write(ResourceHandle handle, byte[] data) throws ROSIXException;
    
    /**
     * 获取资源属性值
     * 
     * @param handle 资源句柄
     * @param key 属性键
     * @return 属性值
     * @throws ROSIXException 如果操作失败
     */
    String getAttribute(ResourceHandle handle, String key) throws ROSIXException;
    
    /**
     * 设置资源属性值
     * 
     * @param handle 资源句柄
     * @param key 属性键
     * @param value 属性值
     * @throws ROSIXException 如果操作失败
     */
    void setAttribute(ResourceHandle handle, String key, String value) throws ROSIXException;
    
    /**
     * 在资源上调用动作
     * 
     * @param handle 资源句柄
     * @param action 要调用的动作名称
     * @param args 动作参数
     * @return 动作执行结果
     * @throws ROSIXException 如果操作失败
     */
    String invoke(ResourceHandle handle, String action, Map<String, Object> args) throws ROSIXException;
    
    /**
     * 订阅资源事件
     * 
     * @param handle 资源句柄
     * @param eventType 要订阅的事件类型
     * @param callback 事件回调函数
     * @return 订阅 ID，用于取消订阅
     * @throws ROSIXException 如果操作失败
     */
    String subscribe(ResourceHandle handle, String eventType, EventCallback callback) throws ROSIXException;
    
    /**
     * 取消订阅资源事件
     * 
     * @param handle 资源句柄
     * @param subscriptionId 订阅 ID
     * @throws ROSIXException 如果操作失败
     */
    void unsubscribe(ResourceHandle handle, String subscriptionId) throws ROSIXException;
    
    /**
     * 创建资源间的层次链接
     * 
     * @param parent 父资源句柄
     * @param child 子资源句柄
     * @throws ROSIXException 如果操作失败
     */
    void link(ResourceHandle parent, ResourceHandle child) throws ROSIXException;
    
    /**
     * 移除资源间的层次链接
     * 
     * @param parent 父资源句柄
     * @param child 子资源句柄
     * @throws ROSIXException 如果操作失败
     */
    void unlink(ResourceHandle parent, ResourceHandle child) throws ROSIXException;
    
    /**
     * 检查资源句柄是否有效
     * 
     * @param handle 要检查的资源句柄
     * @return 如果有效返回 true，否则返回 false
     */
    boolean isValidHandle(ResourceHandle handle);
    
    /**
     * 异步打开资源
     * 
     * @param uri 资源 URI
     * @param mode 访问模式
     * @return 异步资源句柄
     */
    CompletableFuture<ResourceHandle> openAsync(String uri, OpenMode mode);
    
    /**
     * 异步读取资源数据
     * 
     * @param handle 资源句柄
     * @param buffer 缓冲区
     * @return 异步读取结果
     */
    CompletableFuture<Integer> readAsync(ResourceHandle handle, byte[] buffer);
    
    /**
     * 异步写入资源数据
     * 
     * @param handle 资源句柄
     * @param data 数据
     * @return 异步写入结果
     */
    CompletableFuture<Integer> writeAsync(ResourceHandle handle, byte[] data);
}

