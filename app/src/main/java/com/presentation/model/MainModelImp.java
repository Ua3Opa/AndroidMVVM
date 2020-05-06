package com.presentation.model;

import com.presentation.api.MainApiService;
import java.util.Map;
import javax.inject.Inject;

import io.reactivex.Observable;

public class MainModelImp extends BaseModel implements MainModel{

    @Inject
    public MainModelImp() {
    }

    @Override
    public Observable getTestData(Map<String, Object> parameter) {
        return retrofitManager.getRetrofitClient().create(MainApiService.class).getTestData(parameter);
    }
}
