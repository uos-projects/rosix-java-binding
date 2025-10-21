package com.uros.rosix.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * ROSIX 本地库 JNA 接口
 * 映射 C 头文件中定义的函数和结构体
 */
public interface ROSIXLibrary extends Library {
    
    ROSIXLibrary INSTANCE = Native.load("rosix", ROSIXLibrary.class);
    
    // 基本类型定义
    int ROSIX_SUCCESS = 0;
    int ROSIX_ERROR = -1;
    int ROSIX_INVALID_HANDLE = -2;
    int ROSIX_PERMISSION_DENIED = -3;
    int ROSIX_NOT_FOUND = -4;
    int ROSIX_ALREADY_EXISTS = -5;
    int ROSIX_TIMEOUT = -6;
    int ROSIX_INVALID_PARAM = -7;
    int ROSIX_OUT_OF_MEMORY = -8;
    int ROSIX_NOT_SUPPORTED = -9;
    
    // 访问模式常量
    String ROSIX_READ_ONLY = "r";
    String ROSIX_WRITE_ONLY = "w";
    String ROSIX_READ_WRITE = "rw";
    String ROSIX_APPEND = "a";
    String ROSIX_CREATE = "c";
    String ROSIX_EXCLUSIVE = "x";
    
    // 事件类型常量
    String ROSIX_EVENT_UPDATE = "update";
    String ROSIX_EVENT_DELETE = "delete";
    String ROSIX_EVENT_ERROR = "error";
    String ROSIX_EVENT_STATE_CHANGE = "state_change";
    
    /**
     * 资源描述符结构体
     */
    class ResourceDescriptor extends Structure {
        public String uri;
        public String type;
        public String name;
        public String metadata;
        
        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("uri", "type", "name", "metadata");
        }
    }
    
    /**
     * 回调函数类型
     */
    interface ROSIX_Callback extends com.sun.jna.Callback {
        void callback(int handle, String event, Pointer userdata);
    }
    
    // 核心资源操作函数
    int rosix_open(String uri, String mode);
    int rosix_close(int handle);
    long rosix_read(int handle, byte[] buffer, int size);
    long rosix_write(int handle, byte[] data, int size);
    
    // 资源属性和控制函数
    int rosix_getattr(int handle, String key, byte[] value, int len);
    int rosix_setattr(int handle, String key, String value);
    int rosix_invoke(int handle, String action, String args);
    
    // 事件订阅函数
    int rosix_subscribe(int handle, String event, ROSIX_Callback callback, Pointer userdata);
    int rosix_unsubscribe(int handle, String event);
    
    // 资源关系管理函数
    int rosix_link(int parent, int child);
    int rosix_unlink(int parent, int child);
    
    // 工具函数
    int rosix_get_last_error();
    String rosix_strerror(int error_code);
    int rosix_is_valid_handle(int handle);
}
