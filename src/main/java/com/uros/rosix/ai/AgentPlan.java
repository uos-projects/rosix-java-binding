package com.uros.rosix.ai;

import java.time.Instant;
import java.util.List;

/**
 * AI 智能体计划
 * 定义智能体的执行计划
 */
public interface AgentPlan {
    
    /**
     * 获取计划标识符
     * 
     * @return 唯一计划 ID
     */
    String getPlanId();
    
    /**
     * 获取计划描述
     * 
     * @return 计划描述
     */
    String getDescription();
    
    /**
     * 获取计划步骤
     * 
     * @return 计划步骤列表
     */
    List<PlanStep> getSteps();
    
    /**
     * 获取计划优先级
     * 
     * @return 优先级
     */
    int getPriority();
    
    /**
     * 获取计划状态
     * 
     * @return 状态描述
     */
    String getStatus();
    
    /**
     * 获取计划创建时间
     * 
     * @return 创建时间
     */
    Instant getCreatedTime();
    
    /**
     * 获取预计执行时长
     * 
     * @return 预计时长
     */
    Instant getEstimatedDuration();
}

