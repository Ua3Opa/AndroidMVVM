package com.presentation.internal.components;

import android.app.Application;
import android.content.SharedPreferences;

import com.presentation.ProjectApplication;
import com.presentation.database.DaoHelper;
import com.presentation.domain.executor.ThreadExecutor;
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

    DaoHelper provideDaoHelper();
}
