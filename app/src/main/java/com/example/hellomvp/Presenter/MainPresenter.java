package com.example.hellomvp.Presenter;

import com.example.hellomvp.Contract.MainContract;
import com.example.hellomvp.Model.MainModel;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    MainModel model = new MainModel();

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void add(int num) {
        model.add(num);
    }

    @Override
    public String getCounter() {
        return String.valueOf(model.getCounter());
    }

}
