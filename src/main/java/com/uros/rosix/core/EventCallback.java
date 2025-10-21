package com.uros.rosix.core;

/**
 * 资源事件回调接口
 * 用于处理资源状态变化事件
 */
@FunctionalInterface
public interface EventCallback {
    
    /**
     * 处理资源事件
     * 
     * @param handle 触发事件的资源句柄
     * @param eventType 事件类型
     * @param eventData 事件数据
     */
    void onEvent(ResourceHandle handle, String eventType, Object eventData);
}
