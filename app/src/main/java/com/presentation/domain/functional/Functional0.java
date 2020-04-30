package com.presentation.domain.functional;


import io.reactivex.Observable;


@FunctionalInterface
public interface Functional0<T,Params> {
    Observable<T> apply(Params params);
}
