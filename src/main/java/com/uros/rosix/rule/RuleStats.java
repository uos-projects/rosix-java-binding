package com.uros.rosix.rule;

/**
 * 规则统计信息
 * 提供规则执行的性能指标
 */
public interface RuleStats {
    
    /**
     * 获取总执行次数
     * 
     * @return 总执行次数
     */
    long getTotalExecutions();
    
    /**
     * 获取成功执行次数
     * 
     * @return 成功执行次数
     */
    long getSuccessfulExecutions();
    
    /**
     * 获取失败执行次数
     * 
     * @return 失败执行次数
     */
    long getFailedExecutions();
    
    /**
     * 获取成功率
     * 
     * @return 成功率（0.0 到 1.0）
     */
    double getSuccessRate();
}
