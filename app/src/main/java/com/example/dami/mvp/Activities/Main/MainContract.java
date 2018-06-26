package com.example.dami.mvp.Activities.Main;

import com.example.dami.mvp.Models.RandomItem;

import java.util.List;

public interface MainContract {

    interface View{
        void setRecyclerView();
    }

    interface  Presenter{
        void startScheduledService();
        void stopScheduledService();
        void removeRandomItems(List<RandomItem> randomItems);

    }
}
