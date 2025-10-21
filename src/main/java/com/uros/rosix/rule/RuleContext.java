package com.uros.rosix.rule;

import com.uros.rosix.core.ResourceHandle;
import java.time.Instant;

/**
 * 规则执行上下文
 * 包含规则执行所需的信息
 */
public interface RuleContext {
    
    /**
     * 获取触发规则的源资源
     * 
     * @return 源资源句柄
     */
    ResourceHandle getSource();
    
    /**
     * 获取触发规则的事件类型
     * 
     * @return 事件类型
     */
    String getEventType();
    
    /**
     * 获取事件数据
     * 
     * @return 事件数据
     */
    Object getEventData();
    
    /**
     * 获取规则触发时间
     * 
     * @return 触发时间
     */
    Instant getTriggerTime();
    
    /**
     * 获取执行标识符
     * 
     * @return 唯一执行标识符
     */
    String getExecutionId();
}

