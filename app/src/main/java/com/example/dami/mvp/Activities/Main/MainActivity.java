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

public class MainActivity extends AppCompatActivity implements  MainContract.View {
    private  MainPresenter mPresenter;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.start_button) Button startButton;
    @BindView(R.id.stop_button) Button stopButton;
    private RecyclerViewListAdapter mAdapter;
    ArrayList<RandomItem> mRandomItems;

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
        mRandomItems.add(new RandomItem(29, ItemColors.Blue));
        mRandomItems.add(new RandomItem(29, ItemColors.Blue));
        mRandomItems.add(new RandomItem(29, ItemColors.Blue));
        mRandomItems.add(new RandomItem(29, ItemColors.Blue));
        mRandomItems.add(new RandomItem(29, ItemColors.Blue));
        mRandomItems.add(new RandomItem(29, ItemColors.Blue));
        mRandomItems.add(new RandomItem(29, ItemColors.Blue));
        mRandomItems.add(new RandomItem(29, ItemColors.Blue));

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
