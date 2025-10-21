package com.uros.rosix.impl;

import com.uros.rosix.core.ResourceHandle;

/**
 * 默认的资源句柄实现
 * 纯 Java 实现，不依赖本地库
 */
public class DefaultResourceHandle implements ResourceHandle {
    
    private final int handle;
    private final String uri;
    private final String type;
    private final String name;
    
    public DefaultResourceHandle(int handle, String uri, String type, String name) {
        this.handle = handle;
        this.uri = uri;
        this.type = type;
        this.name = name;
    }
    
    public DefaultResourceHandle(int handle, String uri) {
        this(handle, uri, "default", "resource");
    }
    
    @Override
    public String getId() {
        return String.valueOf(handle);
    }
    
    @Override
    public String getUri() {
        return uri;
    }
    
    @Override
    public String getType() {
        return type;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public boolean isValid() {
        return handle > 0;
    }
    
    @Override
    public void close() {
        // 默认实现：标记为无效
        // 在实际实现中，这里会释放相关资源
    }
    
    public int getHandle() {
        return handle;
    }
}