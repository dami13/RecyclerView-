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
        int getRandomItemsListSize();
        void IncrementCounterOfRandomItem(int idx);
        void ResetCounterOfRandomItem(int idx);
        void RemoveRandomItem(int idx);
        void SumOfRandomItems(int idx);
    }

    interface  Presenter{
        void startScheduledService();
        void stopScheduledService();
    }
}
