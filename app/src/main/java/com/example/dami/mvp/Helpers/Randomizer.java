package com.example.dami.mvp.Helpers;

import com.example.dami.mvp.Helpers.Enums.Action;
import com.example.dami.mvp.Helpers.Enums.ItemColors;

import java.util.Random;

public class Randomizer {
    private static Random mRandom;
    private static Randomizer mInstance;

    private Randomizer() { mRandom = new Random(); }

    public static Randomizer getInstance(){
        if(mInstance == null){
            synchronized(Randomizer.class){
                if(mInstance == null) {
                    mInstance = new Randomizer();
                }
            }
        }
        return mInstance;
    }

    public ItemColors getRandomColor(){
        int idx = mRandom.nextInt(ItemColors.values().length);
        return ItemColors.values()[idx];
    }

    public Action getAction(){
        int randInt = mRandom.nextInt(20);
        if(isBetween(randInt, 0, 10)) {
            return Action.IncrementCounter;
        }
        else if(isBetween(randInt, 11, 16)) {
            return Action.ResetCounter;
        }
        else if(isBetween(randInt, 17, 19)) {
            return Action.RemoveRandomElement;
        }
        else {
            return Action.SumCounters;
        }
    }

    public int nextInt(int size){
        return mRandom.nextInt(size);
    }

    private static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
