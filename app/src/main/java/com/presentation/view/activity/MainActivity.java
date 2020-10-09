package com.presentation.view.activity;

import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.persentation.R;
import com.persentation.databinding.ActivityMainBinding;
import com.presentation.dataholder.ApplicationDataHolder;
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

    @Inject
    ApplicationDataHolder applicationDataHolder;
    private ActivityMainBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjector();
        initDataBinding();
    }

    private void initDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
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

        initEvent();

    }

    private void initEvent() {
//        applicationDataHolder.netWorkState().observe(this, result -> {
//            Toast.makeText(this, "网络变动" + result, Toast.LENGTH_SHORT).show();
//        });
        applicationDataHolder.netWorkAvailable().observe(this, result -> {
            Log.d(TAG, "initEvent网络可用: " + result);
        });
    }


}
