package com.uros.rosix.stream;

/**
 * 流处理器接口
 * 用于处理流式数据
 */
@FunctionalInterface
public interface StreamProcessor {
    
    /**
     * 处理流数据
     * 
     * @param data 数据
     * @param size 数据大小
     * @param context 处理上下文
     */
    void process(byte[] data, int size, Object context);
}
