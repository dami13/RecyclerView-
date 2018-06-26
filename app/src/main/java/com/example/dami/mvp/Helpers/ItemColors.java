package com.example.dami.mvp.Helpers;

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
}



