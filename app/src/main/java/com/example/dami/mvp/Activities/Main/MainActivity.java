package com.example.dami.mvp.Activities.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dami.mvp.R;

public class MainActivity extends AppCompatActivity implements  MainContract.View {
    private  MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Init
        mPresenter = new MainPresenter();

    }

    @Override
    public void setRecyclerView() {

    }
}
