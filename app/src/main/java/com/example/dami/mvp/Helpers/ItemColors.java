package com.example.dami.mvp.Helpers;

import android.graphics.Color;

public enum ItemColors {
    Red("#FF0000"),
    Blue("#0000FF");

    private String hexColor;
    ItemColors(String hexColor) {
        this.hexColor = hexColor;
    }

    public String getHexColor(){
        return hexColor;
    }

    public int getColor(){
        return Color.parseColor(hexColor);
    }
}



