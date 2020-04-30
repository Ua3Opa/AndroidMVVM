package com.presentation.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.alibaba.fastjson.JSON;
import com.presentation.entity.Result;
import com.presentation.entity.TestData;
import com.presentation.internal.ComponentHolder;
import com.presentation.model.MainModelImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {

    public ObservableField<CharSequence> mainContent = new ObservableField<>();

    @Inject
    MainModelImp mainModel;

    @Inject
    public MainViewModel(@NonNull Application application) {
        super(application);
        ComponentHolder.getApplicationComponent().inject(this);
    }

    public void getData() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("code", 1);

        mUserCase.withFunctional(mainModel::getTestData, parameters)
                .<Result<List<TestData>>>withProcessor(result -> {
                    Log.d("TAG", "getData: " + JSON.toJSONString(result));
                    handleGetListData(result);
                }).execute();

    }

    private void handleGetListData(Result<List<TestData>> result) {
        if (result.getResultCode() !=0) {
//            super.handleResponseError(result);
            return;
        }
        mainContent.set(JSON.toJSONString(result));
    }

}
