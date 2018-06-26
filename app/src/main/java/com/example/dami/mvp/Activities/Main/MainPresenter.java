package com.example.dami.mvp.Activities.Main;

import android.widget.Toast;

import com.example.dami.mvp.Models.RandomItem;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainPresenter implements MainContract.Presenter {
    private ScheduledExecutorService mService;

    @Override
    public void removeRandomItems(List<RandomItem> randomItems) {
        randomItems.clear();
    }

    @Override
    public void startScheduledService() {
        mService = Executors.newSingleThreadScheduledExecutor();
        mService.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("test-service");
                    // TODO implement
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    @Override
    public void stopScheduledService() {
        mService.shutdown();
    }

    public boolean isScheduledExecutorServiceRunning(){
        return !mService.isTerminated();
    }
}
