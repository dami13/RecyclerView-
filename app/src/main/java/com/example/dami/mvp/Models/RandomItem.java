package com.example.dami.mvp.Models;

import android.graphics.Color;

import com.example.dami.mvp.Helpers.ItemColors;

public class RandomItem {
    private int counter;
    private ItemColors color;

    public RandomItem(int counter, ItemColors color) {
        this.counter = counter;
        this.color = color;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ItemColors getColor() {
        return color;
    }

    public void setColor(ItemColors color) {
        this.color = color;
    }
}
