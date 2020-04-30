package com.presentation.domain.interator;

import com.presentation.data.excutor.JobExecutor;
import com.presentation.domain.executor.ThreadExecutor;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T, Params> {

    private ThreadExecutor threadExecutor;
    private CompositeDisposable disposables;

    public UseCase(ThreadExecutor threadExecutor) {
        this.threadExecutor = threadExecutor;
        disposables = new CompositeDisposable();
    }

    public abstract Observable<T> buildUseCaseObservable(Params params);

    protected void execute(DisposableObserver<T> observer, Params params) {
        Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(AndroidSchedulers.mainThread());
        disposables.add(observable.subscribeWith(observer));
    }

    protected void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        disposables.add(disposable);
    }

    protected void dispose(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

}
