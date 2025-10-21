package com.uros.rosix.resource;

import com.uros.rosix.core.ResourceHandle;

/**
 * 资源引用
 * 包含资源的完整上下文信息
 */
public interface ResourceRef {
    
    /**
     * 获取资源句柄
     * 
     * @return 资源句柄
     */
    ResourceHandle getHandle();
    
    /**
     * 获取空间上下文
     * 
     * @return 空间上下文
     */
    SpatialContext getSpatialContext();
    
    /**
     * 获取时间上下文
     * 
     * @return 时间上下文
     */
    TemporalContext getTemporalContext();
    
    /**
     * 获取语义配置
     * 
     * @return 语义配置
     */
    SemanticProfile getSemanticProfile();
    
    /**
     * 获取资源 URI
     * 
     * @return 资源 URI
     */
    String getUri();
    
    /**
     * 获取当前状态
     * 
     * @return 状态描述
     */
    String getStatus();
}

