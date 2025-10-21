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
 * 提供纯 Java 实现，不依赖本地库
 */
public class DefaultROSIXFactory implements ROSIXFactory {
    
    @Override
    public ROSIX createROSIX() {
        return new DefaultROSIXImpl();
    }

    @Override
    public ResourceSpace createResourceSpace() {
        return new DefaultResourceSpaceImpl();
    }

    @Override
    public ROSIXStream createStream() {
        return new DefaultStreamImpl();
    }

    @Override
    public RuleEngine createRuleEngine() {
        return new DefaultRuleEngineImpl();
    }

    @Override
    public WorkflowEngine createWorkflowEngine() {
        return new DefaultWorkflowEngineImpl();
    }

    @Override
    public AIAgent createAIAgent() {
        return new DefaultAIAgentImpl();
    }
}