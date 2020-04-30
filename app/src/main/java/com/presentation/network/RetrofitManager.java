package com.presentation.network;

import com.presentation.config.Urls;
import com.presentation.network.Interceptors.LoggerInterceptor;
import com.presentation.network.Interceptors.ParamaterInterceptor;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class RetrofitManager {

    private final Retrofit retrofitClient;

    @Inject
    public RetrofitManager() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor())
                .addInterceptor(new ParamaterInterceptor()).build();
        retrofitClient = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Urls.DEFAULT_HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofitClient() {
        return retrofitClient;
    }

}
