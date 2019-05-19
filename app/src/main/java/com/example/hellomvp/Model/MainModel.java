package com.example.hellomvp.Model;

public class MainModel{
    private int count = 0;

    public void add(int num) {
        count += num;
    }

    public int getCounter() {
        return count;
    }
}
