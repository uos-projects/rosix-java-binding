package com.uros.rosix.stream;

import com.uros.rosix.core.EventCallback;
import com.uros.rosix.core.ResourceHandle;
import com.uros.rosix.core.ROSIXException;

/**
 * ROSIX 流式处理接口
 * 提供实时数据处理和事件驱动计算功能
 */
public interface ROSIXStream {
    
    /**
     * 打开流
     * 
     * @param source 源资源句柄
     * @param processor 流处理器
     * @param context 处理上下文
     * @param bufferSize 缓冲区大小
     * @param maxRetries 最大重试次数
     * @param timeoutMs 超时时间（毫秒）
     * @throws ROSIXException 如果打开失败
     */
    void open(ResourceHandle source, StreamProcessor processor, Object context, 
              int bufferSize, int maxRetries, int timeoutMs) throws ROSIXException;
    
    /**
     * 订阅流事件
     * 
     * @param callback 事件回调
     * @throws ROSIXException 如果订阅失败
     */
    void subscribe(EventCallback callback) throws ROSIXException;
    
    /**
     * 取消订阅流事件
     * 
     * @throws ROSIXException 如果取消订阅失败
     */
    void unsubscribe() throws ROSIXException;
    
    /**
     * 关闭流并释放资源
     * 
     * @throws ROSIXException 如果关闭失败
     */
    void close() throws ROSIXException;
    
    /**
     * 开始流处理
     * 
     * @throws ROSIXException 如果启动失败
     */
    void start() throws ROSIXException;
    
    /**
     * 停止流处理
     * 
     * @throws ROSIXException 如果停止失败
     */
    void stop() throws ROSIXException;
    
    /**
     * 暂停流处理
     * 
     * @throws ROSIXException 如果暂停失败
     */
    void pause() throws ROSIXException;
    
    /**
     * 恢复流处理
     * 
     * @throws ROSIXException 如果恢复失败
     */
    void resume() throws ROSIXException;
    
    /**
     * 添加流过滤器
     * 
     * @param filterFunction 过滤函数
     * @param filterContext 过滤上下文
     * @throws ROSIXException 如果添加失败
     */
    void addFilter(StreamProcessor filterFunction, Object filterContext) throws ROSIXException;
    
    /**
     * 添加流转换器
     * 
     * @param transformFunction 转换函数
     * @param transformContext 转换上下文
     * @throws ROSIXException 如果添加失败
     */
    void addTransform(StreamProcessor transformFunction, Object transformContext) throws ROSIXException;
    
    /**
     * 设置流处理速率限制
     * 
     * @param maxRate 最大处理速率（每秒消息数）
     * @throws ROSIXException 如果设置失败
     */
    void setRateLimit(int maxRate) throws ROSIXException;
    
    /**
     * 获取流统计信息
     * 
     * @return 流统计信息
     * @throws ROSIXException 如果获取失败
     */
    StreamStats getStats() throws ROSIXException;
    
    /**
     * 重置流统计信息
     * 
     * @throws ROSIXException 如果重置失败
     */
    void resetStats() throws ROSIXException;
    
    /**
     * 检查流是否活跃
     * 
     * @return 如果活跃返回 true
     */
    boolean isActive();
    
    /**
     * 获取流缓冲区使用率
     * 
     * @return 缓冲区使用率（0-100），如果出错返回 -1
     * @throws ROSIXException 如果获取失败
     */
    int getBufferUsage() throws ROSIXException;
    
    /**
     * 设置流批处理大小
     * 
     * @param batchSize 批处理大小
     * @throws ROSIXException 如果设置失败
     */
    void setBatchSize(int batchSize) throws ROSIXException;
    
    /**
     * 启用流持久化
     * 
     * @param persistencePath 持久化路径
     * @throws ROSIXException 如果启用失败
     */
    void enablePersistence(String persistencePath) throws ROSIXException;
    
    /**
     * 禁用流持久化
     * 
     * @throws ROSIXException 如果禁用失败
     */
    void disablePersistence() throws ROSIXException;
}
