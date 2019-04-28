package com.example.hellomvp.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import com.example.hellomvp.Contract.LoginContract;
import com.example.hellomvp.Model.LoginRepository;
import com.example.hellomvp.Presenter.LoginPresenter;
import com.example.hellomvp.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    LoginContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        presenter = new LoginPresenter(this, new LoginRepository());

        Button button = findViewById(R.id.subBt);
        button.setOnClickListener((v)->{
            presenter.onClickEmailLogin();
        });
    }

    @Override
    public String getInputEmail() {
        return null;
    }

    @Override
    public void showMessageIncorrectEmail() {

    }

    @Override
    public String getInputPassword() {
        return null;
    }

    @Override
    public void showMessageIncorrectPassword() {

    }

    @Override
    public void hideSoftKeyboard() {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void hideLoadingDialog() {

    }

    @Override
    public void showMessageSuccessLogin() {

    }

    @Override
    public void showMessageFailLogin(String errorMsg) {

    }

    @Override
    public void moveActivity() {

    }
}
