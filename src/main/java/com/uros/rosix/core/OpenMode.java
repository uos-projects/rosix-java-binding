package com.uros.rosix.core;

/**
 * 资源访问模式
 * 对应 C 头文件中的访问模式常量
 */
public enum OpenMode {
    READ_ONLY("r"),
    WRITE_ONLY("w"),
    READ_WRITE("rw"),
    APPEND("a"),
    CREATE("c"),
    EXCLUSIVE("x");

    private final String mode;

    OpenMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    @Override
    public String toString() {
        return mode;
    }
}