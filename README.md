# ROSIX Java Binding

这是 ROSIX (Resource Operating System Interface) 的 Java 绑定实现，为 UOS 人机物一体化操作系统提供 Java 编程接口。

## 项目概述

ROSIX 是一个面向**人、机、物一体化操作系统（UOS）**的核心标准接口，提供：

- **统一资源抽象**：为物理资源提供信息空间中的统一抽象
- **多范式编程**：支持命令式、流式、规则式、编排式与 AI 驱动编程
- **标准 Java 接口**：类似 POSIX 风格的资源管理接口
- **AI 原生支持**：内置智能体接口与意图驱动编程模型

## 架构设计

### 核心组件

1. **ROSIX.Core** - 资源访问与控制的基础接口
2. **ResourceSpace** - 资源语义、时空、拓扑模型的统一抽象
3. **Stream** - 流式处理接口，用于实时数据处理
4. **Rule** - 规则引擎接口，用于条件触发和逻辑约束
5. **Workflow** - 工作流编排接口，用于复杂多资源协同
6. **AI** - 智能体接口，提供意图驱动和语义理解能力

### 设计原则

- **接口优先**：先定义 Java 接口，再实现具体功能
- **类型安全**：使用强类型接口，避免直接映射 C 结构体
- **异步支持**：提供异步操作接口
- **异常处理**：统一的异常处理机制
- **JNA 绑定**：通过 JNA 调用本地 C 库

## 项目结构

```
src/main/java/com/uros/rosix/
├── core/                    # 核心接口
│   ├── ROSIX.java          # 主要 ROSIX 接口
│   ├── ResourceHandle.java # 资源句柄接口
│   ├── OpenMode.java       # 访问模式枚举
│   ├── EventCallback.java  # 事件回调接口
│   └── ROSIXException.java # 异常类
├── resource/               # 资源空间接口
│   ├── ResourceSpace.java  # 资源空间接口
│   ├── SpatialContext.java # 空间上下文接口
│   ├── TemporalContext.java# 时间上下文接口
│   ├── SemanticProfile.java# 语义配置接口
│   └── ResourceRef.java    # 资源引用接口
├── stream/                 # 流式处理接口
│   ├── ROSIXStream.java    # 流处理器接口
│   ├── StreamProcessor.java# 流处理器接口
│   └── StreamStats.java    # 流统计信息接口
├── rule/                   # 规则引擎接口
│   ├── RuleEngine.java     # 规则引擎接口
│   ├── Rule.java           # 规则接口
│   ├── RuleContext.java    # 规则上下文接口
│   ├── RuleResult.java     # 规则结果接口
│   └── RuleStats.java      # 规则统计接口
├── workflow/               # 工作流接口
│   ├── WorkflowEngine.java # 工作流引擎接口
│   ├── Task.java           # 任务接口
│   ├── WorkflowContext.java# 工作流上下文接口
│   ├── TaskResult.java     # 任务结果接口
│   └── WorkflowResult.java # 工作流结果接口
├── ai/                     # AI 智能体接口
│   ├── AIAgent.java        # AI 智能体接口
│   ├── AgentConfig.java    # 智能体配置接口
│   ├── AgentContext.java   # 智能体上下文接口
│   ├── AgentResult.java    # 智能体结果接口
│   ├── AgentPlan.java      # 智能体计划接口
│   ├── PlanStep.java       # 计划步骤接口
│   └── AgentMetrics.java   # 智能体指标接口
├── impl/                   # 实现类
│   ├── JNAROSIXImpl.java   # JNA 核心实现
│   ├── JNAResourceHandle.java# JNA 资源句柄实现
│   └── ...                 # 其他 JNA 实现
├── jna/                    # JNA 库接口
│   └── ROSIXLibrary.java   # 本地库 JNA 接口
├── example/                # 示例代码
│   └── ROSIXExample.java   # 使用示例
├── ROSIXFactory.java       # 工厂接口
└── DefaultROSIXFactory.java# 默认工厂实现
```

## 使用方法

### 基本使用

```java
import com.uros.rosix.ROSIXFactory;
import com.uros.rosix.core.ROSIX;
import com.uros.rosix.core.OpenMode;
import com.uros.rosix.core.ResourceHandle;

// 创建 ROSIX 实例
ROSIXFactory factory = ROSIXFactory.getDefault();
ROSIX rosix = factory.createROSIX();

// 打开资源
ResourceHandle handle = rosix.open("sensor://temperature/room1", OpenMode.READ_ONLY);

// 读取数据
byte[] buffer = new byte[1024];
int bytesRead = rosix.read(handle, buffer);

// 获取属性
String temperature = rosix.getAttribute(handle, "temperature");

// 调用动作
Map<String, Object> args = Map.of("mode", "auto", "intensity", 3);
String result = rosix.invoke(handle, "purify_air", args);

// 关闭资源
rosix.close(handle);
```

### 异步操作

```java
// 异步打开资源
CompletableFuture<ResourceHandle> future = rosix.openAsync("sensor://temperature/room1", OpenMode.READ_ONLY);

future.thenAccept(handle -> {
    try {
        // 处理资源
        byte[] buffer = new byte[1024];
        int bytesRead = rosix.read(handle, buffer);
        System.out.println("Read " + bytesRead + " bytes");
    } catch (ROSIXException e) {
        e.printStackTrace();
    }
});
```

### 事件订阅

```java
// 订阅资源事件
String subscriptionId = rosix.subscribe(handle, "update", (h, eventType, eventData) -> {
    System.out.println("Event received: " + eventType);
    System.out.println("Data: " + eventData);
});

// 取消订阅
rosix.unsubscribe(handle, subscriptionId);
```

## 构建和运行

### 使用 Maven

```bash
# 编译项目
mvn clean compile

# 运行示例
mvn exec:java -Dexec.mainClass="com.uros.rosix.example.ROSIXExample"

# 打包
mvn clean package
```

### 依赖要求

- Java 17+
- Maven 3.6+
- JNA 5.13.0+
- Jackson 2.15.3+

## 开发状态

### 已完成

- ✅ Java 接口设计
- ✅ 核心接口定义
- ✅ 资源空间接口
- ✅ 流式处理接口
- ✅ 规则引擎接口
- ✅ 工作流接口
- ✅ AI 智能体接口
- ✅ JNA 绑定框架
- ✅ 基础实现类

### 待实现

- ⏳ 完整的 JNA 本地库绑定
- ⏳ 具体的数据类实现
- ⏳ 完整的错误处理
- ⏳ 性能优化
- ⏳ 单元测试
- ⏳ 文档完善

## 注意事项

1. **本地库依赖**：当前实现需要对应的 C 库支持
2. **异常处理**：大部分功能目前抛出 `NOT_SUPPORTED` 异常
3. **性能考虑**：JNA 调用有一定的性能开销
4. **线程安全**：当前实现不是线程安全的

## 贡献

欢迎贡献代码！请遵循以下步骤：

1. Fork 项目
2. 创建功能分支
3. 提交更改
4. 创建 Pull Request

## 许可证

本项目采用 MIT 许可证。详见 LICENSE 文件。

## 相关链接

- [ROSIX 白皮书](https://github.com/uos-projects/uos-rosix)
- [UOS 项目](https://github.com/uos-projects)
- [JNA 文档](https://github.com/java-native-access/jna)

