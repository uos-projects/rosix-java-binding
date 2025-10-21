package com.uros.rosix.ai;

import java.util.List;

/**
 * AI 智能体配置
 * 定义智能体的基本配置信息
 */
public interface AgentConfig {
    
    /**
     * 获取智能体标识符
     * 
     * @return 智能体 ID
     */
    String getAgentId();
    
    /**
     * 获取模型 URI
     * 
     * @return 模型 URI 或标识符
     */
    String getModelUri();
    
    /**
     * 获取系统提示或上下文
     * 
     * @return 系统提示
     */
    String getPrompt();
    
    /**
     * 获取输出格式
     * 
     * @return 输出格式描述
     */
    String getOutput();
    
    /**
     * 获取智能体能力列表
     * 
     * @return 能力列表
     */
    List<String> getCapabilities();
    
    /**
     * 获取智能体版本
     * 
     * @return 版本信息
     */
    String getVersion();
    
    /**
     * 获取最大令牌数
     * 
     * @return 响应的最大令牌数
     */
    int getMaxTokens();
    
    /**
     * 获取响应创造性
     * 
     * @return 创造性参数（0.0-1.0）
     */
    double getTemperature();
}

