package com.presentation;

import android.app.Application;
import android.content.Intent;

import com.presentation.internal.ComponentHolder;
import com.presentation.internal.components.ApplicationComponent;
import com.presentation.internal.components.DaggerApplicationComponent;
import com.presentation.internal.modules.ApplicationModule;
import com.presentation.service.SystemEventService;


public class ProjectApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        startApplicationService();
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
        ComponentHolder.setApplicationComponent(applicationComponent);
    }

    private void startApplicationService() {
        startService(new Intent(this, SystemEventService.class));
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        stopService(new Intent(this,SystemEventService.class));
    }
}
