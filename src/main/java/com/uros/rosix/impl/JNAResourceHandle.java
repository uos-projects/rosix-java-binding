package com.uros.rosix.impl;

import com.uros.rosix.core.ResourceHandle;

/**
 * 基于 JNA 的资源句柄实现
 */
public class JNAResourceHandle implements ResourceHandle {
    
    private final int handle;
    private final String uri;
    private final String type;
    private final String name;
    private boolean closed = false;
    
    public JNAResourceHandle(int handle, String uri) {
        this.handle = handle;
        this.uri = uri;
        this.type = extractTypeFromUri(uri);
        this.name = extractNameFromUri(uri);
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
    public boolean isValid() {
        return !closed && handle >= 0;
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
    public void close() {
        closed = true;
    }
    
    public int getHandle() {
        return handle;
    }
    
    private String extractTypeFromUri(String uri) {
        if (uri == null || !uri.contains("://")) {
            return "unknown";
        }
        String[] parts = uri.split("://");
        if (parts.length > 1) {
            String[] pathParts = parts[1].split("/");
            return pathParts.length > 0 ? pathParts[0] : "unknown";
        }
        return "unknown";
    }
    
    private String extractNameFromUri(String uri) {
        if (uri == null) {
            return "unknown";
        }
        String[] parts = uri.split("/");
        return parts.length > 0 ? parts[parts.length - 1] : "unknown";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JNAResourceHandle that = (JNAResourceHandle) obj;
        return handle == that.handle;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(handle);
    }
    
    @Override
    public String toString() {
        return "JNAResourceHandle{" +
                "handle=" + handle +
                ", uri='" + uri + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                '}';
    }
}
