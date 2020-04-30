package com.presentation.internal.modules;

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
    MainViewModel provideMainViewModel(MainActivity mainActivity) {
        return new MainViewModel(mainActivity);
    }

}
