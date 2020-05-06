package com.presentation.domain.functional;


import android.util.Log;

import com.google.gson.JsonParseException;
import com.presentation.config.Exceptions;
import com.presentation.entity.Result;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class ResultObservable<T> extends DisposableObserver<T> {

    private static final String TAG = "ResultObservable";
    private Effect0<T> mEffect0;

    public ResultObservable(Effect0<T> effect0) {
        this.mEffect0 = effect0;
    }

    @Override
    public void onNext(@NonNull T result) {
        mEffect0.apply(result);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        handleErrorException(e);
    }

    private void handleErrorException(Throwable e) {
        Result<Object> listResult;
        if (e instanceof JsonParseException) {
            listResult = new Result<>(Exceptions.JSON_PARSE_EXCEPTION.getExceptionCode(), Exceptions.JSON_PARSE_EXCEPTION.getExceptionMessage());
        } else {
            listResult = new Result<>(Exceptions.UNKNOWN_EXCEPTION.getExceptionCode(), Exceptions.UNKNOWN_EXCEPTION.getExceptionMessage());
        }
        mEffect0.apply((T) listResult);
    }

    @Override
    public void onComplete() {
    }
}
