package com.presentation;

import android.app.Application;

import com.presentation.internal.ComponentHolder;
import com.presentation.internal.components.ApplicationComponent;
import com.presentation.internal.components.DaggerApplicationComponent;
import com.presentation.internal.modules.ApplicationModule;


public class ProjectApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }


    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
        ComponentHolder.setApplicationComponent(applicationComponent);
    }
}
