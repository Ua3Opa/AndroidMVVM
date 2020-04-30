package com.presentation.internal.modules;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.presentation.domain.executor.ThreadExecutor;
import com.presentation.domain.functional.FunctionalUseCase;
import com.presentation.model.MainModel;
import com.presentation.view.activity.MainActivity;
import com.presentation.viewmodel.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    MainActivity activity() {
        return this.activity;
    }

    @Provides
    MainViewModel provideMainViewModel(Application mainActivity) {
        return new MainViewModel(mainActivity);
    }

}
