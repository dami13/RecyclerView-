package com.example.dami.mvp.Activities.Main;

import com.example.dami.mvp.Adapters.Lists.RecyclerViewListAdapter;
import com.example.dami.mvp.Models.RandomItem;

import java.util.List;

public interface MainContract {

    interface View{
        void setRecyclerView();
        void notifyRandomItemsListChanged();
        void addRandomItem(RandomItem item);
        void runOnMainThread(Runnable runnable);
    }

    interface  Presenter{
        void startScheduledService();
        void stopScheduledService();
        void removeRandomItems();
    }
}
