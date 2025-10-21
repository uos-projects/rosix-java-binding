package com.uros.rosix.core;

/**
 * 资源句柄
 * 封装对资源的引用，提供类型安全的资源访问
 */
public interface ResourceHandle {
    
    /**
     * 获取资源的唯一标识符
     * 
     * @return 资源 ID
     */
    String getId();
    
    /**
     * 获取资源 URI
     * 
     * @return 资源 URI
     */
    String getUri();
    
    /**
     * 检查句柄是否有效
     * 
     * @return 如果有效返回 true
     */
    boolean isValid();
    
    /**
     * 获取资源类型
     * 
     * @return 资源类型
     */
    String getType();
    
    /**
     * 获取资源名称
     * 
     * @return 资源名称
     */
    String getName();
    
    /**
     * 关闭资源句柄
     * 释放相关资源
     */
    void close();
}