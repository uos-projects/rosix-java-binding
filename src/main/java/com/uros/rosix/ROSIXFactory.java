package com.uros.rosix;

import com.uros.rosix.ai.AIAgent;
import com.uros.rosix.core.ROSIX;
import com.uros.rosix.resource.ResourceSpace;
import com.uros.rosix.rule.RuleEngine;
import com.uros.rosix.stream.ROSIXStream;
import com.uros.rosix.workflow.WorkflowEngine;

/**
 * ROSIX 工厂接口
 * 提供创建各种 ROSIX 组件的统一入口
 */
public interface ROSIXFactory {
    
    /**
     * 创建 ROSIX 核心实例
     * 
     * @return ROSIX 核心实例
     */
    ROSIX createROSIX();
    
    /**
     * 创建资源空间实例
     * 
     * @return 资源空间实例
     */
    ResourceSpace createResourceSpace();
    
    /**
     * 创建流处理器实例
     * 
     * @return 流处理器实例
     */
    ROSIXStream createStream();
    
    /**
     * 创建规则引擎实例
     * 
     * @return 规则引擎实例
     */
    RuleEngine createRuleEngine();
    
    /**
     * 创建工作流引擎实例
     * 
     * @return 工作流引擎实例
     */
    WorkflowEngine createWorkflowEngine();
    
    /**
     * 创建 AI 智能体实例
     * 
     * @return AI 智能体实例
     */
    AIAgent createAIAgent();
    
    /**
     * 获取默认工厂实例
     * 
     * @return 默认工厂实例
     */
    static ROSIXFactory getDefault() {
        return new DefaultROSIXFactory();
    }
}
