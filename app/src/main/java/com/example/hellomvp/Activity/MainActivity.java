package com.example.hellomvp.Activity;

import android.os.Bundle;
import android.view.View;

import com.example.hellomvp.Contract.MainContract;
import com.example.hellomvp.Presenter.MainPresenter;
import com.example.hellomvp.R;
import com.example.hellomvp.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    ActivityMainBinding binding;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.setView(this);
    }

    private void add(int num){
        presenter.add(num);
        updateCount();
    }

    @Override
    public void updateCount() {
        binding.countTv.setText(presenter.getCounter());
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.addBt:
                add(1);
                break;

            case R.id.subBt:
                add(-1);
                break;

            default:
                break;

        }
    }
}
