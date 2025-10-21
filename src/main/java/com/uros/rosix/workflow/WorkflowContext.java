package com.uros.rosix.workflow;

import java.time.Instant;

/**
 * 工作流执行上下文
 * 包含工作流执行的状态信息
 */
public interface WorkflowContext {
    
    /**
     * 获取执行标识符
     * 
     * @return 唯一执行 ID
     */
    String getExecutionId();
    
    /**
     * 获取工作流名称
     * 
     * @return 工作流名称
     */
    String getWorkflowName();
    
    /**
     * 获取执行开始时间
     * 
     * @return 开始时间
     */
    Instant getStartTime();
    
    /**
     * 获取执行结束时间
     * 
     * @return 结束时间
     */
    Instant getEndTime();
    
    /**
     * 获取执行状态
     * 
     * @return 状态码
     */
    int getStatus();
    
    /**
     * 获取当前执行的任务
     * 
     * @return 当前任务名称
     */
    String getCurrentTask();
    
    /**
     * 获取用户定义数据
     * 
     * @return 用户数据
     */
    Object getUserData();
}

