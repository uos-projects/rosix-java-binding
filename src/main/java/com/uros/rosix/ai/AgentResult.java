package com.uros.rosix.ai;

import com.uros.rosix.core.ROSIXException.ROSIXErrorCode;

/**
 * AI 智能体执行结果
 * 包含智能体执行的结果信息
 */
public interface AgentResult {
    
    /**
     * 获取智能体响应
     * 
     * @return 响应内容
     */
    String getResponse();
    
    /**
     * 获取执行的动作
     * 
     * @return 动作描述
     */
    String getActionTaken();
    
    /**
     * 获取结果代码
     * 
     * @return 结果代码
     */
    ROSIXErrorCode getResultCode();
    
    /**
     * 获取置信度
     * 
     * @return 置信度（0.0-1.0）
     */
    double getConfidence();
    
    /**
     * 获取推理解释
     * 
     * @return 推理过程
     */
    String getReasoning();
    
    /**
     * 获取处理时间（毫秒）
     * 
     * @return 处理时间
     */
    long getProcessingTime();
}
