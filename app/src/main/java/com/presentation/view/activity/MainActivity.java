package com.presentation.view.activity;

import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.persentation.R;
import com.persentation.databinding.ActivityMainBinding;
import com.presentation.internal.ComponentHolder;
import com.presentation.internal.components.DaggerMainComponent;
import com.presentation.internal.modules.MainModule;
import com.presentation.view.BaseActivity;
import com.presentation.viewmodel.MainViewModel;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    SharedPreferences sp;

    @Inject
    MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjector();
        initDataBinding();
    }

    private void initDataBinding() {
        ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewDataBinding.setMainViewModel(mMainViewModel);
    }

    private void initInjector() {
        DaggerMainComponent.builder()
                .applicationComponent(ComponentHolder.getApplicationComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainViewModel.getData();
    }



}
