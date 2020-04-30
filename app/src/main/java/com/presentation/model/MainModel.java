package com.presentation.model;


import com.presentation.entity.Result;

import java.util.Map;


import io.reactivex.Observable;
import retrofit2.http.QueryMap;

public interface MainModel {
    Observable<Result> getTestData(@QueryMap Map<String, Object> parameter);
}
