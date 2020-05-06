package com.presentation.config;

public class Config {

    public enum ENVIRONMENT {
        DEVELOP,PRODUCTION
    }

    public static ENVIRONMENT environment =ENVIRONMENT.DEVELOP;

    public static final String SP_NAME = "PROJECT_SP";
}
