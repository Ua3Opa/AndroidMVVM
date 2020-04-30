package com.presentation.config;

public enum Exceptions {

    JSON_PARSE_EXCEPTION(0, "Json解析异常"),
    NETWORK_EXCEPTION(1, "网络异常"),
    UNKNOWN_EXCEPTION(-1, "未知错误");

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
