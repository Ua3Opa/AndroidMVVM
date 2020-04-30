package com.presentation.domain.functional;

import com.presentation.domain.executor.ThreadExecutor;
import com.presentation.domain.interator.UseCase;
import com.presentation.entity.Result;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;


public class FunctionalUseCase extends UseCase {

    private Functional0 mFunction;
    private ResultObservable mObservable;
    private Map<String, Object> mParameter;

    @Inject
    public FunctionalUseCase(ThreadExecutor threadExecutor) {
        super(threadExecutor);
    }

    public FunctionalUseCase withFunctional(Functional0<Observable,Map<String,Object>> functional, Map<String, Object> parameter) {
        mFunction = functional;
        mParameter = parameter;
        return this;
    }

    @Override
    public Observable buildUseCaseObservable(Object o) {
        return mFunction.apply(mParameter);
    }

    public <T> FunctionalUseCase withProcessor(Effect0<T> effect0) {
        mObservable = new ResultObservable(effect0);
        return this;
    }

    public void execute() {
        super.execute(mObservable, null);
    }

}
