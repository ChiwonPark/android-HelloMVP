package com.example.hellomvp.Model;

import com.example.hellomvp.Contract.MainContract;

public class MainModel implements MainContract.Model {
    private int count = 0;

    @Override
    public void add(int num) {
        count += num;
    }

    @Override
    public int getCounter() {
        return count;
    }
}
