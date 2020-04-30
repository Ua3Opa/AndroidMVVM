package com.presentation.data.excutor;

import com.presentation.domain.executor.ThreadExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class JobExecutor implements ThreadExecutor {

    private static final int corePoolSize = 3;
    private static final int maximumPoolSize = 3;
    private static final int keepAliveTime = 15;

    private final ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public JobExecutor() {
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new JobThreadFactory());
    }

    @Override
    public void execute(Runnable command) {
        threadPoolExecutor.execute(command);
    }

    private static class JobThreadFactory implements ThreadFactory {

        private int counter;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"JobThread_" + counter++);
        }

    }

}
