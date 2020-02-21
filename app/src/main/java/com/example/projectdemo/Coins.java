package com.example.projectdemo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
public class Coins extends RealmObject {
    @PrimaryKey
    private int id=1;
    private long score;

    public Coins(){

    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}

