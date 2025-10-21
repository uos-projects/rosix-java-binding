package com.uros.rosix.workflow;

import com.uros.rosix.core.ROSIXException;
import java.util.List;

/**
 * 工作流任务接口
 * 定义工作流中的单个任务
 */
public interface Task {
    
    /**
     * 获取任务名称
     * 
     * @return 唯一任务名称
     */
    String getTaskName();
    
    /**
     * 获取任务依赖
     * 
     * @return 依赖任务名称列表
     */
    List<String> getDependencies();
    
    /**
     * 执行任务
     * 
     * @param context 执行上下文
     * @return 执行结果
     * @throws ROSIXException 如果执行失败
     */
    TaskResult execute(Object context) throws ROSIXException;
    
    /**
     * 获取任务超时时间（秒）
     * 
     * @return 超时时间
     */
    int getTimeoutSeconds();
    
    /**
     * 获取最大重试次数
     * 
     * @return 重试次数
     */
    int getRetryCount();
    
    /**
     * 获取任务描述
     * 
     * @return 任务描述
     */
    String getDescription();
}

