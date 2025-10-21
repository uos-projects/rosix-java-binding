package com.uros.rosix.stream;

/**
 * 流统计信息
 * 提供流处理的性能指标
 */
public interface StreamStats {
    
    /**
     * 获取已处理的字节总数
     * 
     * @return 字节总数
     */
    long getBytesProcessed();
    
    /**
     * 获取已处理的消息总数
     * 
     * @return 消息总数
     */
    long getMessagesProcessed();
    
    /**
     * 获取遇到的错误总数
     * 
     * @return 错误总数
     */
    long getErrors();
    
    /**
     * 获取平均处理时间（毫秒）
     * 
     * @return 平均处理时间
     */
    double getAverageProcessingTime();
    
    /**
     * 获取吞吐量（字节/秒）
     * 
     * @return 吞吐量
     */
    double getThroughput();
}
