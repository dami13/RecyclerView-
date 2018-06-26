package com.example.dami.mvp.Activities.Main;

import android.widget.Toast;

import com.example.dami.mvp.Adapters.Lists.RecyclerViewListAdapter;
import com.example.dami.mvp.Helpers.ItemColors;
import com.example.dami.mvp.Models.RandomItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainPresenter implements MainContract.Presenter {
    private ScheduledExecutorService mService;
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void removeRandomItems() {
        //m.mRandomItems.clear();
    }

    @Override
    public void startScheduledService() {
        mService = Executors.newSingleThreadScheduledExecutor();
        mService.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                try {
                    mView.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            mView.addRandomItem(new RandomItem(20, ItemColors.Red));
                            //TODO
                        }
                    });
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
        if(mService != null)
            return !mService.isTerminated();
        else
            return false;
    }
}
