package com.uros.rosix.resource;

import java.util.List;

/**
 * 语义配置
 * 描述资源的能力和本体信息
 */
public interface SemanticProfile {
    
    /**
     * 获取资源类型标识符
     * 
     * @return 资源类型
     */
    String getType();
    
    /**
     * 获取能力列表
     * 
     * @return 能力列表
     */
    List<String> getCapabilities();
    
    /**
     * 获取本体 URI
     * 
     * @return 本体 URI
     */
    String getOntologyUri();
    
    /**
     * 获取资源版本
     * 
     * @return 版本信息
     */
    String getVersion();
    
    /**
     * 获取制造商信息
     * 
     * @return 制造商
     */
    String getManufacturer();
    
    /**
     * 获取型号信息
     * 
     * @return 型号
     */
    String getModel();
}
