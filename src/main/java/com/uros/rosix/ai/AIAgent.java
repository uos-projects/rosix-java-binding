package com.uros.rosix.ai;

import com.uros.rosix.core.ResourceHandle;
import com.uros.rosix.core.ROSIXException;
import java.util.List;

/**
 * AI 智能体接口
 * 提供意图驱动和语义理解能力
 */
public interface AIAgent {
    
    /**
     * 创建 AI 智能体
     * 
     * @param config 智能体配置
     * @throws ROSIXException 如果创建失败
     */
    void createAgent(AgentConfig config) throws ROSIXException;
    
    /**
     * 删除 AI 智能体
     * 
     * @param agentId 智能体标识符
     * @throws ROSIXException 如果删除失败
     */
    void deleteAgent(String agentId) throws ROSIXException;
    
    /**
     * 更新 AI 智能体配置
     * 
     * @param agentId 智能体标识符
     * @param config 更新的配置
     * @throws ROSIXException 如果更新失败
     */
    void updateAgent(String agentId, AgentConfig config) throws ROSIXException;
    
    /**
     * 获取 AI 智能体信息
     * 
     * @param agentId 智能体标识符
     * @return 智能体配置
     * @throws ROSIXException 如果获取失败
     */
    AgentConfig getAgentInfo(String agentId) throws ROSIXException;
    
    /**
     * 调用 AI 智能体
     * 
     * @param agentId 智能体标识符
     * @param context 执行上下文
     * @return 执行结果
     * @throws ROSIXException 如果调用失败
     */
    AgentResult invokeAgent(String agentId, AgentContext context) throws ROSIXException;
    
    /**
     * 将 AI 智能体绑定到资源
     * 
     * @param agentId 智能体标识符
     * @param resourceHandle 要绑定的资源句柄
     * @throws ROSIXException 如果绑定失败
     */
    void bindAgent(String agentId, ResourceHandle resourceHandle) throws ROSIXException;
    
    /**
     * 从资源解绑 AI 智能体
     * 
     * @param agentId 智能体标识符
     * @param resourceHandle 要解绑的资源句柄
     * @throws ROSIXException 如果解绑失败
     */
    void unbindAgent(String agentId, ResourceHandle resourceHandle) throws ROSIXException;
    
    /**
     * 获取智能体绑定的资源
     * 
     * @param agentId 智能体标识符
     * @param maxResources 最大资源数量
     * @return 资源句柄列表
     * @throws ROSIXException 如果获取失败
     */
    List<ResourceHandle> getBoundResources(String agentId, int maxResources) throws ROSIXException;
    
    /**
     * 创建智能体计划
     * 
     * @param agentId 智能体标识符
     * @param intent 用户意图
     * @return 创建的计划
     * @throws ROSIXException 如果创建失败
     */
    AgentPlan createPlan(String agentId, String intent) throws ROSIXException;
    
    /**
     * 执行智能体计划
     * 
     * @param planId 计划标识符
     * @return 执行结果
     * @throws ROSIXException 如果执行失败
     */
    AgentResult executePlan(String planId) throws ROSIXException;
    
    /**
     * 获取计划执行状态
     * 
     * @param planId 计划标识符
     * @return 计划状态
     * @throws ROSIXException 如果获取失败
     */
    String getPlanStatus(String planId) throws ROSIXException;
    
    /**
     * 取消智能体计划
     * 
     * @param planId 计划标识符
     * @throws ROSIXException 如果取消失败
     */
    void cancelPlan(String planId) throws ROSIXException;
    
    /**
     * 训练智能体
     * 
     * @param agentId 智能体标识符
     * @param trainingData 训练数据
     * @throws ROSIXException 如果训练失败
     */
    void trainAgent(String agentId, byte[] trainingData) throws ROSIXException;
    
    /**
     * 更新智能体模型
     * 
     * @param agentId 智能体标识符
     * @param modelUri 新模型 URI
     * @throws ROSIXException 如果更新失败
     */
    void updateAgentModel(String agentId, String modelUri) throws ROSIXException;
    
    /**
     * 获取智能体性能指标
     * 
     * @param agentId 智能体标识符
     * @return 性能指标
     * @throws ROSIXException 如果获取失败
     */
    AgentMetrics getAgentMetrics(String agentId) throws ROSIXException;
    
    /**
     * 列出所有可用的智能体
     * 
     * @param maxAgents 最大智能体数量
     * @return 智能体标识符列表
     * @throws ROSIXException 如果列出失败
     */
    List<String> listAgents(int maxAgents) throws ROSIXException;
}
