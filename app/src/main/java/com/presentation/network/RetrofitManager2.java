package com.presentation.network;

import com.presentation.network.Interceptors.LoggerInterceptor;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofitManager,api初始化类
 */
public class RetrofitManager2 {
    public static final String TAG = "RetrofitManager : ";
    private static RetrofitManager2 retrofitManager = new RetrofitManager2();
    public Retrofit retrofit;
    public Map<String, Retrofit> cacheRetrofit = new HashMap<>();

    public static RetrofitManager2 getInstance() {
        return retrofitManager;
    }

    /**
     * 初始化okhttp 和 retrofit
     */
    public void init(String baseUrl) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor()).build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    private Retrofit createNewRequest(String baseUrl) {
        if (cacheRetrofit.containsKey(baseUrl)) {
            return cacheRetrofit.get(baseUrl);
        }
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor()).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cacheRetrofit.put(baseUrl, retrofit);
        return retrofit;
    }


}
