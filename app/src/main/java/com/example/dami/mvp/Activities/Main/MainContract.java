package com.example.dami.mvp.Activities.Main;

public interface MainContract {

    interface View{
        void setRecyclerView();
    }

    interface  Presenter{
        void startThread();
        void stopThread();
        void removeRandomItems();

    }
}
