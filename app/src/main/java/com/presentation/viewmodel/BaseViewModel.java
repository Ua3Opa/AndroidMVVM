package com.presentation.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.presentation.domain.functional.FunctionalUseCase;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

public class BaseViewModel extends ViewModel {

    @Inject
    protected FunctionalUseCase mUserCase;

    protected RxAppCompatActivity mActivity;

    public BaseViewModel(@NonNull RxAppCompatActivity activity) {
        mActivity = activity;
    }

    protected LifecycleTransformer<Object> getLifecycleTransformer() {
        return mActivity.bindUntilEvent(ActivityEvent.DESTROY);
    }


}
