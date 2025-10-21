package com.uros.rosix.resource;

import com.uros.rosix.core.ResourceHandle;
import com.uros.rosix.core.ROSIXException;
import java.time.Instant;
import java.util.List;

/**
 * 资源空间接口
 * 提供资源的时空语义管理功能
 */
public interface ResourceSpace {
    
    /**
     * 解析资源 URI 为完整的资源引用
     * 
     * @param uri 资源 URI
     * @return 资源引用
     * @throws ROSIXException 如果解析失败
     */
    ResourceRef resolve(String uri) throws ROSIXException;
    
    /**
     * 更新资源的空间上下文
     * 
     * @param handle 资源句柄
     * @param spatialContext 空间上下文
     * @throws ROSIXException 如果更新失败
     */
    void updateSpatialContext(ResourceHandle handle, SpatialContext spatialContext) throws ROSIXException;
    
    /**
     * 更新资源的时间上下文
     * 
     * @param handle 资源句柄
     * @param temporalContext 时间上下文
     * @throws ROSIXException 如果更新失败
     */
    void updateTemporalContext(ResourceHandle handle, TemporalContext temporalContext) throws ROSIXException;
    
    /**
     * 更新资源的语义配置
     * 
     * @param handle 资源句柄
     * @param semanticProfile 语义配置
     * @throws ROSIXException 如果更新失败
     */
    void updateSemanticProfile(ResourceHandle handle, SemanticProfile semanticProfile) throws ROSIXException;
    
    /**
     * 查询资源的拓扑邻居
     * 
     * @param handle 资源句柄
     * @param maxNeighbors 最大邻居数量
     * @return 邻居资源引用列表
     * @throws ROSIXException 如果查询失败
     */
    List<ResourceRef> queryTopology(ResourceHandle handle, int maxNeighbors) throws ROSIXException;
    
    /**
     * 在空间范围内查询资源
     * 
     * @param centerX 中心 X 坐标
     * @param centerY 中心 Y 坐标
     * @param centerZ 中心 Z 坐标
     * @param radius 搜索半径
     * @param maxResults 最大结果数量
     * @return 匹配的资源引用列表
     * @throws ROSIXException 如果查询失败
     */
    List<ResourceRef> querySpatialRange(double centerX, double centerY, double centerZ, 
                                       double radius, int maxResults) throws ROSIXException;
    
    /**
     * 按类型查询资源
     * 
     * @param type 资源类型
     * @param maxResults 最大结果数量
     * @return 匹配的资源引用列表
     * @throws ROSIXException 如果查询失败
     */
    List<ResourceRef> queryByType(String type, int maxResults) throws ROSIXException;
    
    /**
     * 按能力查询资源
     * 
     * @param capability 能力描述
     * @param maxResults 最大结果数量
     * @return 匹配的资源引用列表
     * @throws ROSIXException 如果查询失败
     */
    List<ResourceRef> queryByCapability(String capability, int maxResults) throws ROSIXException;
    
    /**
     * 获取资源的历史空间上下文
     * 
     * @param handle 资源句柄
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param maxContexts 最大上下文数量
     * @return 历史空间上下文列表
     * @throws ROSIXException 如果查询失败
     */
    List<SpatialContext> getSpatialHistory(ResourceHandle handle, Instant startTime, 
                                          Instant endTime, int maxContexts) throws ROSIXException;
    
    /**
     * 获取资源的历史时间上下文
     * 
     * @param handle 资源句柄
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param maxContexts 最大上下文数量
     * @return 历史时间上下文列表
     * @throws ROSIXException 如果查询失败
     */
    List<TemporalContext> getTemporalHistory(ResourceHandle handle, Instant startTime, 
                                            Instant endTime, int maxContexts) throws ROSIXException;
    
    /**
     * 创建资源状态快照
     * 
     * @param handle 资源句柄
     * @return 快照 ID
     * @throws ROSIXException 如果创建失败
     */
    String createSnapshot(ResourceHandle handle) throws ROSIXException;
    
    /**
     * 从快照恢复资源状态
     * 
     * @param handle 资源句柄
     * @param snapshotId 快照 ID
     * @throws ROSIXException 如果恢复失败
     */
    void restoreSnapshot(ResourceHandle handle, String snapshotId) throws ROSIXException;
    
    /**
     * 计算两个资源间的空间距离
     * 
     * @param handle1 第一个资源句柄
     * @param handle2 第二个资源句柄
     * @return 距离（米），如果出错返回 -1.0
     * @throws ROSIXException 如果计算失败
     */
    double calculateDistance(ResourceHandle handle1, ResourceHandle handle2) throws ROSIXException;
    
    /**
     * 检查两个资源是否空间相邻
     * 
     * @param handle1 第一个资源句柄
     * @param handle2 第二个资源句柄
     * @param threshold 相邻阈值（米）
     * @return 如果相邻返回 true
     * @throws ROSIXException 如果检查失败
     */
    boolean isAdjacent(ResourceHandle handle1, ResourceHandle handle2, double threshold) throws ROSIXException;
}

