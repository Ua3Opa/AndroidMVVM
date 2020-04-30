package com.presentation.internal.components;

import com.presentation.data.scope.ForActivity;
import com.presentation.internal.modules.MainModule;
import com.presentation.view.activity.MainActivity;

import dagger.Component;

@ForActivity
@Component(dependencies = ApplicationComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
