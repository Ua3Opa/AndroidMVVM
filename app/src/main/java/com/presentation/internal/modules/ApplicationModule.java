package com.presentation.internal.modules;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.presentation.ProjectApplication;
import com.presentation.config.Config;
import com.presentation.data.excutor.JobExecutor;
import com.presentation.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    ProjectApplication application;

    public ApplicationModule(ProjectApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideJobExecutor(JobExecutor jobExecutor){
        return jobExecutor;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context){
        return context.getSharedPreferences(Config.SP_NAME,Context.MODE_PRIVATE);
    }

}
