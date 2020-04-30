package com.presentation.service;

import com.presentation.entity.Result;
import com.presentation.entity.TestData;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface MainApiService {
    @GET("/api/RoomApi/live")
    Observable<Result<List<TestData>>> getTestData(@QueryMap Map<String, Object> paramater);
}
