package com.presentation.viewmodel;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.alibaba.fastjson.JSON;
import com.presentation.entity.Result;
import com.presentation.entity.TestData;
import com.presentation.internal.ComponentHolder;
import com.presentation.model.MainModelImp;
import com.presentation.view.activity.MainActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {

    public ObservableField<String> mainContent = new ObservableField<>();

    @Inject
    MainModelImp mainModel;

    @Inject
    public MainViewModel(@NonNull MainActivity activity) {
        super(activity);
        ComponentHolder.getApplicationComponent().inject(this);
    }

    public void getData() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("code", 1);

        mUserCase.withFunctional(mainModel::getTestData, parameters)
                .compose(getLifecycleTransformer())
                .<Result<List<TestData>>>withProcessor(result -> {
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
