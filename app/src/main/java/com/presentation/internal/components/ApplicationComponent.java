package com.presentation.internal.components;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.presentation.ProjectApplication;
import com.presentation.data.excutor.JobExecutor;
import com.presentation.domain.executor.ThreadExecutor;
import com.presentation.domain.interator.UseCase;
import com.presentation.internal.modules.ApplicationModule;
import com.presentation.viewmodel.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(ProjectApplication projectApplication);

    void inject(MainViewModel mainViewModel);

    Application provideApplication();

    SharedPreferences provideSharedPreferences();

    ThreadExecutor provideJobExecutor();
}
