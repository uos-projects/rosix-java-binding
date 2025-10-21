package com.uros.rosix.workflow;

import com.uros.rosix.core.ROSIXException;
import java.time.Instant;
import java.util.List;

/**
 * 工作流引擎接口
 * 提供复杂多资源、多阶段协同编排功能
 */
public interface WorkflowEngine {
    
    /**
     * 创建工作流
     * 
     * @param name 工作流名称
     * @throws ROSIXException 如果创建失败
     */
    void createWorkflow(String name) throws ROSIXException;
    
    /**
     * 向工作流添加任务
     * 
     * @param workflowName 工作流名称
     * @param task 要添加的任务
     * @throws ROSIXException 如果添加失败
     */
    void addTask(String workflowName, Task task) throws ROSIXException;
    
    /**
     * 从工作流移除任务
     * 
     * @param workflowName 工作流名称
     * @param taskName 要移除的任务名称
     * @throws ROSIXException 如果移除失败
     */
    void removeTask(String workflowName, String taskName) throws ROSIXException;
    
    /**
     * 更新工作流中的任务
     * 
     * @param workflowName 工作流名称
     * @param taskName 要更新的任务名称
     * @param task 更新后的任务定义
     * @throws ROSIXException 如果更新失败
     */
    void updateTask(String workflowName, String taskName, Task task) throws ROSIXException;
    
    /**
     * 启动工作流执行
     * 
     * @param workflowName 要启动的工作流名称
     * @param context 执行上下文
     * @return 执行 ID
     * @throws ROSIXException 如果启动失败
     */
    String startWorkflow(String workflowName, WorkflowContext context) throws ROSIXException;
    
    /**
     * 停止工作流执行
     * 
     * @param executionId 执行 ID
     * @throws ROSIXException 如果停止失败
     */
    void stopWorkflow(String executionId) throws ROSIXException;
    
    /**
     * 暂停工作流执行
     * 
     * @param executionId 执行 ID
     * @throws ROSIXException 如果暂停失败
     */
    void pauseWorkflow(String executionId) throws ROSIXException;
    
    /**
     * 恢复工作流执行
     * 
     * @param executionId 执行 ID
     * @throws ROSIXException 如果恢复失败
     */
    void resumeWorkflow(String executionId) throws ROSIXException;
    
    /**
     * 获取工作流执行状态
     * 
     * @param executionId 执行 ID
     * @return 执行上下文
     * @throws ROSIXException 如果获取失败
     */
    WorkflowContext getWorkflowStatus(String executionId) throws ROSIXException;
    
    /**
     * 获取工作流执行结果
     * 
     * @param executionId 执行 ID
     * @return 执行结果
     * @throws ROSIXException 如果获取失败
     */
    WorkflowResult getWorkflowResult(String executionId) throws ROSIXException;
    
    /**
     * 列出所有正在运行的工作流执行
     * 
     * @param maxExecutions 最大执行数量
     * @return 执行 ID 列表
     * @throws ROSIXException 如果列出失败
     */
    List<String> listRunningWorkflows(int maxExecutions) throws ROSIXException;
    
    /**
     * 获取工作流执行历史
     * 
     * @param workflowName 工作流名称
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param maxResults 最大结果数量
     * @return 执行结果列表
     * @throws ROSIXException 如果获取失败
     */
    List<WorkflowResult> getWorkflowHistory(String workflowName, Instant startTime, 
                                           Instant endTime, int maxResults) throws ROSIXException;
    
    /**
     * 验证工作流依赖
     * 
     * @param workflowName 工作流名称
     * @throws ROSIXException 如果验证失败
     */
    void validateWorkflowDependencies(String workflowName) throws ROSIXException;
    
    /**
     * 设置工作流调度策略
     * 
     * @param workflowName 工作流名称
     * @param policy 调度策略（如 "immediate", "scheduled", "conditional"）
     * @param scheduleData 策略特定数据
     * @throws ROSIXException 如果设置失败
     */
    void setWorkflowSchedule(String workflowName, String policy, String scheduleData) throws ROSIXException;
    
    /**
     * 保存工作流到文件
     * 
     * @param workflowName 工作流名称
     * @param filename 文件名
     * @throws ROSIXException 如果保存失败
     */
    void saveWorkflow(String workflowName, String filename) throws ROSIXException;
    
    /**
     * 从文件加载工作流
     * 
     * @param filename 文件名
     * @return 工作流名称
     * @throws ROSIXException 如果加载失败
     */
    String loadWorkflow(String filename) throws ROSIXException;
    
    /**
     * 导出工作流为 JSON
     * 
     * @param workflowName 工作流名称
     * @return JSON 字符串
     * @throws ROSIXException 如果导出失败
     */
    String exportWorkflowToJson(String workflowName) throws ROSIXException;
    
    /**
     * 从 JSON 导入工作流
     * 
     * @param jsonInput JSON 字符串
     * @return 工作流名称
     * @throws ROSIXException 如果导入失败
     */
    String importWorkflowFromJson(String jsonInput) throws ROSIXException;
    
    /**
     * 列出所有可用的工作流
     * 
     * @param maxWorkflows 最大工作流数量
     * @return 工作流名称列表
     * @throws ROSIXException 如果列出失败
     */
    List<String> listWorkflows(int maxWorkflows) throws ROSIXException;
    
    /**
     * 删除工作流
     * 
     * @param workflowName 工作流名称
     * @throws ROSIXException 如果删除失败
     */
    void deleteWorkflow(String workflowName) throws ROSIXException;
}

