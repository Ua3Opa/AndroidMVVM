package com.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.presentation.domain.functional.FunctionalUseCase;
import com.presentation.entity.Result;
import com.presentation.view.BaseActivity;

import javax.inject.Inject;

public class BaseViewModel extends AndroidViewModel {

    @Inject
    protected FunctionalUseCase mUserCase;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }


}
