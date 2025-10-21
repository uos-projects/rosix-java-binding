package com.uros.rosix.ai;

import java.time.Instant;

/**
 * AI 智能体执行上下文
 * 包含智能体执行所需的信息
 */
public interface AgentContext {
    
    /**
     * 获取会话标识符
     * 
     * @return 会话 ID
     */
    String getSessionId();
    
    /**
     * 获取用户标识符
     * 
     * @return 用户 ID
     */
    String getUserId();
    
    /**
     * 获取用户意图或查询
     * 
     * @return 用户意图
     */
    String getIntent();
    
    /**
     * 获取附加上下文信息
     * 
     * @return 上下文信息
     */
    String getContext();
    
    /**
     * 获取请求时间戳
     * 
     * @return 请求时间
     */
    Instant getTimestamp();
    
    /**
     * 获取用户定义数据
     * 
     * @return 用户数据
     */
    Object getUserData();
}

