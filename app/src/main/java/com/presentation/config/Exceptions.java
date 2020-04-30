package com.presentation.config;

public enum Exceptions {

    UNKNOWN_EXCEPTION(-1, "未知错误"),
    JSON_PARSE_EXCEPTION(0, "数据解析异常"),
    NETWORK_EXCEPTION(1, "网络异常");

    private int ExceptionCode;
    private String ExceptionMessage;

    Exceptions(int exceptionCode, String exceptionMessage) {
        ExceptionCode = exceptionCode;
        ExceptionMessage = exceptionMessage;
    }

    public int getExceptionCode() {
        return ExceptionCode;
    }

    public String getExceptionMessage() {
        return ExceptionMessage;
    }

}
