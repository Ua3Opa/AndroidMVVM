package com.presentation.network.Interceptors;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.net.URLDecoder;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LoggerInterceptor implements Interceptor {
    private static String TAG = "LoggerInterceptor";

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        Response response = chain.proceed(request);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        Log.i(TAG, "intercept: "+"\n");
        Log.i(TAG, "----------Start----------------");
        try {
            Log.i(TAG, "| " + URLDecoder.decode(request.toString(), "UTF-8"));
        } catch (Exception ex) {
            Log.i(TAG, "Exception | " + ex.getMessage());
        }

        String method = request.method();
        //打印post请求参数
        if ("POST".equals(method)) {
            StringBuilder sb = new StringBuilder();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.append(body.encodedName(i)).append("=").append(body.encodedValue(i)).append(",");
                }
                if (sb.length() >= 1) {
                    sb.delete(sb.length() - 1, sb.length());
                }
                Log.i(TAG, "| RequestParams:{" + sb.toString() + "}");
            }
        }
        Log.i(TAG, "| Response:" + content);
        Log.i(TAG, "----------End:" + duration + "毫秒----------");
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}
