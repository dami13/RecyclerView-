package com.example.dami.mvp.Activities.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

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
    private MainPresenter mPresenter;
    private RecyclerViewListAdapter mAdapter;

    @OnClick(R.id.start_button)
    public void startButtonClicked(){
        if(!mPresenter.isScheduledExecutorServiceRunning()) {
            mPresenter.startScheduledService();
            stopButton.setText(R.string.button_text_stop);
            Toast.makeText(this, R.string.service_started, Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, R.string.service_running, Toast.LENGTH_SHORT).show();
    }

    public void runOnMainThread(Runnable runnable) {
            this.runOnUiThread(runnable);
    }

    @OnClick(R.id.stop_button)
    public void stopButtonClicked(){
        if(mPresenter.isScheduledExecutorServiceRunning()) {
            mPresenter.stopScheduledService();
            stopButton.setText(R.string.button_text_reset);
            Toast.makeText(this, R.string.service_terminated, Toast.LENGTH_SHORT).show();
        }
        else
        {
            mAdapter.clear();
            mAdapter.notifyDataSetChanged();
            Toast.makeText(this, R.string.list_cleared, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Init
        mPresenter = new MainPresenter(this);
        ButterKnife.bind(this);
        setRecyclerView();
    }

    @Override
    public void notifyRandomItemsListChanged() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void addRandomItem(RandomItem item) {
        mAdapter.add(item);
    }

    @Override
    public int getRandomItemsListSize() {
        return mAdapter.mRandomItems.size();
    }

    @Override
    public void setRecyclerView() {
        mAdapter = new RecyclerViewListAdapter(new ArrayList<RandomItem>());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
    }
}
