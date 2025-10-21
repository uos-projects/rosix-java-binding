package com.uros.rosix.rule;

/**
 * 规则接口
 * 定义条件-动作对
 */
public interface Rule {
    
    /**
     * 获取条件表达式
     * 
     * @return 条件表达式（例如："temperature > 28"）
     */
    String getCondition();
    
    /**
     * 获取动作表达式
     * 
     * @return 动作表达式（例如："fan = ON"）
     */
    String getAction();
    
    /**
     * 获取规则优先级
     * 
     * @return 优先级（数字越大优先级越高）
     */
    int getPriority();
    
    /**
     * 获取规则描述
     * 
     * @return 人类可读的规则描述
     */
    String getDescription();
    
    /**
     * 检查规则是否启用
     * 
     * @return 如果启用返回 true
     */
    boolean isEnabled();
}
