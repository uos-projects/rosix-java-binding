package com.uros.rosix;

import com.uros.rosix.ai.AIAgent;
import com.uros.rosix.core.ROSIX;
import com.uros.rosix.impl.*;
import com.uros.rosix.resource.ResourceSpace;
import com.uros.rosix.rule.RuleEngine;
import com.uros.rosix.stream.ROSIXStream;
import com.uros.rosix.workflow.WorkflowEngine;

/**
 * 默认 ROSIX 工厂实现
 * 提供基于 JNA 的本地库绑定实现
 */
public class DefaultROSIXFactory implements ROSIXFactory {
    
    @Override
    public ROSIX createROSIX() {
        return new JNAROSIXImpl();
    }
    
    @Override
    public ResourceSpace createResourceSpace() {
        return new JNAResourceSpaceImpl();
    }
    
    @Override
    public ROSIXStream createStream() {
        return new JNAStreamImpl();
    }
    
    @Override
    public RuleEngine createRuleEngine() {
        return new JNARuleEngineImpl();
    }
    
    @Override
    public WorkflowEngine createWorkflowEngine() {
        return new JNAWorkflowEngineImpl();
    }
    
    @Override
    public AIAgent createAIAgent() {
        return new JNAAIAgentImpl();
    }
}
