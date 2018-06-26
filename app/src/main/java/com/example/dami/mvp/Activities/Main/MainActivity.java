package com.example.dami.mvp.Activities.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.dami.mvp.Adapters.Lists.RecyclerViewListAdapter;
import com.example.dami.mvp.Helpers.ItemColors;
import com.example.dami.mvp.Models.RandomItem;
import com.example.dami.mvp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements  MainContract.View {
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.start_button) Button startButton;
    @BindView(R.id.stop_button) Button stopButton;
    ArrayList<RandomItem> mRandomItems;
    private  MainPresenter mPresenter;
    private RecyclerViewListAdapter mAdapter;

    @OnClick(R.id.start_button)
    public void startButtonClicked(){
        mPresenter.startScheduledService();
        stopButton.setText("Stop");
    }

    @OnClick(R.id.stop_button)
    public void stopButtonClicked(){
        if(mPresenter.isScheduledExecutorServiceRunning()) {
            mPresenter.stopScheduledService();
            stopButton.setText("Reset");
        }
        else
        {
            mPresenter.removeRandomItems(mRandomItems);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // Init
        mRandomItems = new ArrayList<RandomItem>();
        mPresenter = new MainPresenter();
        //for test
        mRandomItems.add(new RandomItem(29, ItemColors.Blue));
        mRandomItems.add(new RandomItem(29, ItemColors.Red));

        setRecyclerView();
    }

    @Override
    public void setRecyclerView() {
        mAdapter = new RecyclerViewListAdapter(mRandomItems);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
    }
}
