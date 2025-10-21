package com.uros.rosix.example;

import com.uros.rosix.ROSIXFactory;
import com.uros.rosix.core.ROSIX;
import com.uros.rosix.core.ROSIXException;
import com.uros.rosix.core.OpenMode;
import com.uros.rosix.core.ResourceHandle;

/**
 * ROSIX Java 绑定示例
 * 演示如何使用 ROSIX Java 接口
 */
public class ROSIXExample {
    
    public static void main(String[] args) {
        try {
            // 创建 ROSIX 工厂
            ROSIXFactory factory = ROSIXFactory.getDefault();
            
            System.out.println("=== ROSIX Java Binding Example ===");
            System.out.println("Creating ROSIX instance...");
            
            // 注意：由于本地库尚未实现，这些调用会抛出异常
            // 这里仅演示接口的使用方式
            try {
                // 创建 ROSIX 核心实例
                ROSIX rosix = factory.createROSIX();
                
                // 示例：打开资源
                ResourceHandle handle = rosix.open("sensor://temperature/room1", OpenMode.READ_ONLY);
                System.out.println("Resource opened: " + handle.getUri());
                System.out.println("Resource type: " + handle.getType());
                System.out.println("Resource name: " + handle.getName());
                
                // 读取数据
                byte[] buffer = new byte[1024];
                int bytesRead = rosix.read(handle, buffer);
                System.out.println("Read " + bytesRead + " bytes from resource");
                
                // 获取属性
                String value = rosix.getAttribute(handle, "temperature");
                System.out.println("Temperature: " + value);
                
                // 关闭资源
                rosix.close(handle);
                System.out.println("Resource closed");
                
            } catch (UnsatisfiedLinkError e) {
                System.out.println("Expected error (native library not found): " + e.getMessage());
                System.out.println("This is expected since the native ROSIX library is not yet implemented.");
            } catch (ROSIXException e) {
                System.out.println("Expected error (local library not implemented): " + e.getMessage());
            }
            
            // 演示其他组件
            System.out.println("\n=== Other Components ===");
            System.out.println("ResourceSpace: " + factory.createResourceSpace().getClass().getSimpleName());
            System.out.println("Stream: " + factory.createStream().getClass().getSimpleName());
            System.out.println("RuleEngine: " + factory.createRuleEngine().getClass().getSimpleName());
            System.out.println("WorkflowEngine: " + factory.createWorkflowEngine().getClass().getSimpleName());
            System.out.println("AIAgent: " + factory.createAIAgent().getClass().getSimpleName());
            
            System.out.println("\n=== Example Completed ===");
            System.out.println("ROSIX Java binding is ready for use!");
            System.out.println("Note: Full functionality requires the native ROSIX library to be implemented.");
            
        } catch (Exception e) {
            System.err.println("Error in example: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
