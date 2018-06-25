package com.example.dami.mvp.Activities.Main;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.dami.mvp.Adapters.Lists.RecyclerViewListAdapter;
import com.example.dami.mvp.Helpers.ItemColors;
import com.example.dami.mvp.Models.RandomItem;
import com.example.dami.mvp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  MainContract.View {
    private  MainPresenter mPresenter;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
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
        mPresenter.GetRecyclerViewItems();
        //for test
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
