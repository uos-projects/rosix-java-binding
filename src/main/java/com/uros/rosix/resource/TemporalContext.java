package com.uros.rosix.resource;

import java.time.Instant;

/**
 * 时间上下文
 * 表示资源在时间维度上的状态信息
 */
public interface TemporalContext {
    
    /**
     * 获取时间戳
     * 
     * @return 时间戳
     */
    Instant getTimestamp();
    
    /**
     * 获取当前状态描述
     * 
     * @return 状态描述
     */
    String getState();
    
    /**
     * 获取趋势描述
     * 
     * @return 趋势（如 "increasing", "stable", "decreasing"）
     */
    String getTrend();
    
    /**
     * 获取置信度
     * 
     * @return 置信度（0.0 到 1.0）
     */
    double getConfidence();
    
    /**
     * 获取未来状态预测
     * 
     * @return 预测描述
     */
    String getPrediction();
}
