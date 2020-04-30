package com.presentation.model;

import com.presentation.network.RetrofitManager;

import javax.inject.Inject;

public class BaseModel {
    @Inject
    RetrofitManager retrofitManager;

    @Inject
    public BaseModel() {
    }
}
