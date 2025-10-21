package com.uros.rosix.workflow;

import com.uros.rosix.core.ROSIXException.ROSIXErrorCode;
import java.time.Instant;

/**
 * 任务执行结果
 * 包含单个任务的执行结果信息
 */
public interface TaskResult {
    
    /**
     * 获取任务名称
     * 
     * @return 任务名称
     */
    String getTaskName();
    
    /**
     * 获取执行结果代码
     * 
     * @return 结果代码
     */
    ROSIXErrorCode getResult();
    
    /**
     * 获取结果消息
     * 
     * @return 结果消息
     */
    String getMessage();
    
    /**
     * 获取任务开始时间
     * 
     * @return 开始时间
     */
    Instant getStartTime();
    
    /**
     * 获取任务结束时间
     * 
     * @return 结束时间
     */
    Instant getEndTime();
    
    /**
     * 获取重试次数
     * 
     * @return 重试次数
     */
    int getRetryCount();
}
