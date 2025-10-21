package com.uros.rosix.impl;

import com.uros.rosix.core.*;
import com.uros.rosix.jna.ROSIXLibrary;
import com.uros.rosix.jna.ROSIXLibrary.ROSIX_Callback;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于 JNA 的 ROSIX 核心实现
 * 通过 JNA 调用本地 C 库
 */
public class JNAROSIXImpl implements ROSIX {
    
    private final ROSIXLibrary rosixLib;
    private final Map<String, EventCallback> callbacks = new ConcurrentHashMap<>();
    
    public JNAROSIXImpl() {
        this.rosixLib = ROSIXLibrary.INSTANCE;
    }
    
    @Override
    public ResourceHandle open(String uri, OpenMode mode) throws ROSIXException {
        try {
            int handle = rosixLib.rosix_open(uri, mode.getMode());
            if (handle < 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode(handle), 
                    "Failed to open resource: " + uri);
            }
            return new JNAResourceHandle(handle, uri);
        } catch (Exception e) {
            throw new ROSIXException(ROSIXException.ROSIXErrorCode.ERROR, 
                "Error opening resource: " + uri, e);
        }
    }
    
    @Override
    public void close(ResourceHandle handle) throws ROSIXException {
        if (handle instanceof JNAResourceHandle) {
            JNAResourceHandle jnaHandle = (JNAResourceHandle) handle;
            int result = rosixLib.rosix_close(jnaHandle.getHandle());
            if (result != 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode(result), 
                    "Failed to close resource handle");
            }
        }
    }
    
    @Override
    public int read(ResourceHandle handle, byte[] buffer) throws ROSIXException {
        if (handle instanceof JNAResourceHandle) {
            JNAResourceHandle jnaHandle = (JNAResourceHandle) handle;
            long result = rosixLib.rosix_read(jnaHandle.getHandle(), buffer, buffer.length);
            if (result < 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode((int) result), 
                    "Failed to read from resource");
            }
            return (int) result;
        }
        throw new ROSIXException(ROSIXException.ROSIXErrorCode.INVALID_HANDLE, 
            "Invalid resource handle");
    }
    
    @Override
    public int write(ResourceHandle handle, byte[] data) throws ROSIXException {
        if (handle instanceof JNAResourceHandle) {
            JNAResourceHandle jnaHandle = (JNAResourceHandle) handle;
            long result = rosixLib.rosix_write(jnaHandle.getHandle(), data, data.length);
            if (result < 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode((int) result), 
                    "Failed to write to resource");
            }
            return (int) result;
        }
        throw new ROSIXException(ROSIXException.ROSIXErrorCode.INVALID_HANDLE, 
            "Invalid resource handle");
    }
    
    @Override
    public String getAttribute(ResourceHandle handle, String key) throws ROSIXException {
        if (handle instanceof JNAResourceHandle) {
            JNAResourceHandle jnaHandle = (JNAResourceHandle) handle;
            byte[] buffer = new byte[1024];
            int result = rosixLib.rosix_getattr(jnaHandle.getHandle(), key, buffer, buffer.length);
            if (result != 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode(result), 
                    "Failed to get attribute: " + key);
            }
            return new String(buffer).trim();
        }
        throw new ROSIXException(ROSIXException.ROSIXErrorCode.INVALID_HANDLE, 
            "Invalid resource handle");
    }
    
    @Override
    public void setAttribute(ResourceHandle handle, String key, String value) throws ROSIXException {
        if (handle instanceof JNAResourceHandle) {
            JNAResourceHandle jnaHandle = (JNAResourceHandle) handle;
            int result = rosixLib.rosix_setattr(jnaHandle.getHandle(), key, value);
            if (result != 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode(result), 
                    "Failed to set attribute: " + key);
            }
        } else {
            throw new ROSIXException(ROSIXException.ROSIXErrorCode.INVALID_HANDLE, 
                "Invalid resource handle");
        }
    }
    
    @Override
    public String invoke(ResourceHandle handle, String action, Map<String, Object> args) throws ROSIXException {
        if (handle instanceof JNAResourceHandle) {
            JNAResourceHandle jnaHandle = (JNAResourceHandle) handle;
            // 将参数转换为 JSON 字符串
            String argsJson = convertArgsToJson(args);
            int result = rosixLib.rosix_invoke(jnaHandle.getHandle(), action, argsJson);
            if (result != 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode(result), 
                    "Failed to invoke action: " + action);
            }
            return "Action invoked successfully";
        }
        throw new ROSIXException(ROSIXException.ROSIXErrorCode.INVALID_HANDLE, 
            "Invalid resource handle");
    }
    
    @Override
    public String subscribe(ResourceHandle handle, String eventType, EventCallback callback) throws ROSIXException {
        if (handle instanceof JNAResourceHandle) {
            JNAResourceHandle jnaHandle = (JNAResourceHandle) handle;
            String subscriptionId = generateSubscriptionId();
            callbacks.put(subscriptionId, callback);
            
            ROSIX_Callback jnaCallback = (h, event, userData) -> {
                callback.onEvent(handle, event, null);
            };
            
            int result = rosixLib.rosix_subscribe(jnaHandle.getHandle(), eventType, jnaCallback, null);
            if (result != 0) {
                callbacks.remove(subscriptionId);
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode(result), 
                    "Failed to subscribe to event: " + eventType);
            }
            return subscriptionId;
        }
        throw new ROSIXException(ROSIXException.ROSIXErrorCode.INVALID_HANDLE, 
            "Invalid resource handle");
    }
    
    @Override
    public void unsubscribe(ResourceHandle handle, String subscriptionId) throws ROSIXException {
        if (handle instanceof JNAResourceHandle) {
            JNAResourceHandle jnaHandle = (JNAResourceHandle) handle;
            callbacks.remove(subscriptionId);
            int result = rosixLib.rosix_unsubscribe(jnaHandle.getHandle(), subscriptionId);
            if (result != 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode(result), 
                    "Failed to unsubscribe from event");
            }
        } else {
            throw new ROSIXException(ROSIXException.ROSIXErrorCode.INVALID_HANDLE, 
                "Invalid resource handle");
        }
    }
    
    @Override
    public void link(ResourceHandle parent, ResourceHandle child) throws ROSIXException {
        if (parent instanceof JNAResourceHandle && child instanceof JNAResourceHandle) {
            JNAResourceHandle jnaParent = (JNAResourceHandle) parent;
            JNAResourceHandle jnaChild = (JNAResourceHandle) child;
            int result = rosixLib.rosix_link(jnaParent.getHandle(), jnaChild.getHandle());
            if (result != 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode(result), 
                    "Failed to link resources");
            }
        } else {
            throw new ROSIXException(ROSIXException.ROSIXErrorCode.INVALID_HANDLE, 
                "Invalid resource handles");
        }
    }
    
    @Override
    public void unlink(ResourceHandle parent, ResourceHandle child) throws ROSIXException {
        if (parent instanceof JNAResourceHandle && child instanceof JNAResourceHandle) {
            JNAResourceHandle jnaParent = (JNAResourceHandle) parent;
            JNAResourceHandle jnaChild = (JNAResourceHandle) child;
            int result = rosixLib.rosix_unlink(jnaParent.getHandle(), jnaChild.getHandle());
            if (result != 0) {
                throw new ROSIXException(ROSIXException.ROSIXErrorCode.fromCode(result), 
                    "Failed to unlink resources");
            }
        } else {
            throw new ROSIXException(ROSIXException.ROSIXErrorCode.INVALID_HANDLE, 
                "Invalid resource handles");
        }
    }
    
    @Override
    public boolean isValidHandle(ResourceHandle handle) {
        if (handle instanceof JNAResourceHandle) {
            JNAResourceHandle jnaHandle = (JNAResourceHandle) handle;
            return rosixLib.rosix_is_valid_handle(jnaHandle.getHandle()) != 0;
        }
        return false;
    }
    
    @Override
    public CompletableFuture<ResourceHandle> openAsync(String uri, OpenMode mode) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return open(uri, mode);
            } catch (ROSIXException e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    @Override
    public CompletableFuture<Integer> readAsync(ResourceHandle handle, byte[] buffer) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return read(handle, buffer);
            } catch (ROSIXException e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    @Override
    public CompletableFuture<Integer> writeAsync(ResourceHandle handle, byte[] data) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return write(handle, data);
            } catch (ROSIXException e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    private String convertArgsToJson(Map<String, Object> args) {
        // 简单的 JSON 转换实现
        StringBuilder json = new StringBuilder("{");
        boolean first = true;
        for (Map.Entry<String, Object> entry : args.entrySet()) {
            if (!first) {
                json.append(",");
            }
            json.append("\"").append(entry.getKey()).append("\":");
            if (entry.getValue() instanceof String) {
                json.append("\"").append(entry.getValue()).append("\"");
            } else {
                json.append(entry.getValue());
            }
            first = false;
        }
        json.append("}");
        return json.toString();
    }
    
    private String generateSubscriptionId() {
        return "sub_" + System.currentTimeMillis() + "_" + Thread.currentThread().threadId();
    }
}
