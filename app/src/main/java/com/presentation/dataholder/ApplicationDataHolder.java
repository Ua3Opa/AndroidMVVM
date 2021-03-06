package com.presentation.dataholder;


import androidx.lifecycle.MutableLiveData;

import com.presentation.network.NetWorkType;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApplicationDataHolder {
    @Inject
    public ApplicationDataHolder() {
    }

    MutableLiveData<NetWorkType> netWorkState = new MutableLiveData<>();

    MutableLiveData<Boolean> netWorkAvailable = new MutableLiveData<>();

    public MutableLiveData<NetWorkType> netWorkState() {
        return netWorkState;
    }

    public MutableLiveData<Boolean> netWorkAvailable() {
        return netWorkAvailable;
    }

}
