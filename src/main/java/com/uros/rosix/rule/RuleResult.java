package com.uros.rosix.rule;

import com.uros.rosix.core.ROSIXException.ROSIXErrorCode;
import java.time.Instant;

/**
 * 规则执行结果
 * 包含规则执行的结果信息
 */
public interface RuleResult {
    
    /**
     * 检查执行是否成功
     * 
     * @return 如果成功返回 true
     */
    boolean isSuccess();
    
    /**
     * 获取执行结果消息
     * 
     * @return 结果消息
     */
    String getMessage();
    
    /**
     * 获取执行的动作
     * 
     * @return 动作描述
     */
    String getActionTaken();
    
    /**
     * 获取动作执行时间
     * 
     * @return 执行时间
     */
    Instant getExecutionTime();
    
    /**
     * 获取结果代码
     * 
     * @return 结果代码
     */
    ROSIXErrorCode getResultCode();
}
