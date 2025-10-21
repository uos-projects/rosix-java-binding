package com.uros.rosix.ai;

/**
 * AI 智能体性能指标
 * 提供智能体的性能统计信息
 */
public interface AgentMetrics {
    
    /**
     * 获取准确率
     * 
     * @return 准确率（0.0-1.0）
     */
    double getAccuracy();
    
    /**
     * 获取平均响应时间
     * 
     * @return 平均响应时间（毫秒）
     */
    double getAverageResponseTime();
    
    /**
     * 获取成功率
     * 
     * @return 成功率（0.0-1.0）
     */
    double getSuccessRate();
}

