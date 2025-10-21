package com.uros.rosix.core;

/**
 * ROSIX 操作异常
 * 封装 ROSIX 操作过程中的错误信息
 */
public class ROSIXException extends Exception {
    
    private final ROSIXErrorCode errorCode;
    
    public ROSIXException(ROSIXErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public ROSIXException(ROSIXErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    
    public ROSIXErrorCode getErrorCode() {
        return errorCode;
    }
    
    /**
     * ROSIX 错误代码枚举
     */
    public enum ROSIXErrorCode {
        SUCCESS(0),
        ERROR(-1),
        INVALID_HANDLE(-2),
        PERMISSION_DENIED(-3),
        NOT_FOUND(-4),
        ALREADY_EXISTS(-5),
        TIMEOUT(-6),
        INVALID_PARAM(-7),
        OUT_OF_MEMORY(-8),
        NOT_SUPPORTED(-9);
        
        private final int code;
        
        ROSIXErrorCode(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return code;
        }
        
        public static ROSIXErrorCode fromCode(int code) {
            for (ROSIXErrorCode errorCode : values()) {
                if (errorCode.code == code) {
                    return errorCode;
                }
            }
            return ERROR;
        }
    }
}
