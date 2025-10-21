package com.uros.rosix.resource;

/**
 * 空间上下文
 * 表示资源在三维空间中的位置和方向
 */
public interface SpatialContext {
    
    /**
     * 获取 X 坐标
     * 
     * @return X 坐标
     */
    double getX();
    
    /**
     * 获取 Y 坐标
     * 
     * @return Y 坐标
     */
    double getY();
    
    /**
     * 获取 Z 坐标
     * 
     * @return Z 坐标
     */
    double getZ();
    
    /**
     * 获取方向向量
     * 
     * @return 方向向量 [roll, pitch, yaw]
     */
    double[] getOrientation();
    
    /**
     * 获取位置精度（米）
     * 
     * @return 位置精度
     */
    double getAccuracy();
    
    /**
     * 获取坐标系标识符
     * 
     * @return 坐标系标识符
     */
    String getCoordinateSystem();
}
