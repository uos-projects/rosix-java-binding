package com.uros.rosix.ai;

/**
 * AI 智能体计划步骤
 * 定义计划中的单个执行步骤
 */
public interface PlanStep {
    
    /**
     * 获取步骤标识符
     * 
     * @return 步骤 ID
     */
    String getStepId();
    
    /**
     * 获取要执行的动作
     * 
     * @return 动作描述
     */
    String getAction();
    
    /**
     * 获取目标资源 URI
     * 
     * @return 目标资源 URI
     */
    String getTargetResource();
    
    /**
     * 获取步骤参数
     * 
     * @return 参数描述
     */
    String getParameters();
    
    /**
     * 获取执行顺序
     * 
     * @return 执行顺序
     */
    int getOrder();
    
    /**
     * 获取步骤状态
     * 
     * @return 状态描述
     */
    String getStatus();
}

