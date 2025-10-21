package com.uros.rosix.workflow;

import com.uros.rosix.core.ROSIXException.ROSIXErrorCode;
import java.time.Instant;
import java.util.List;

/**
 * 工作流执行结果
 * 包含整个工作流的执行结果信息
 */
public interface WorkflowResult {
    
    /**
     * 获取执行标识符
     * 
     * @return 执行 ID
     */
    String getExecutionId();
    
    /**
     * 获取整体执行结果
     * 
     * @return 结果代码
     */
    ROSIXErrorCode getOverallResult();
    
    /**
     * 获取任务结果列表
     * 
     * @return 任务结果列表
     */
    List<TaskResult> getTaskResults();
    
    /**
     * 获取总执行时长
     * 
     * @return 总时长
     */
    Instant getTotalDuration();
    
    /**
     * 获取执行摘要
     * 
     * @return 摘要描述
     */
    String getSummary();
}
