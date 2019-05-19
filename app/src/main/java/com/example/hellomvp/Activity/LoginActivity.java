package com.example.hellomvp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hellomvp.Contract.LoginContract;
import com.example.hellomvp.Model.LoginRepository;
import com.example.hellomvp.Presenter.LoginPresenter;
import com.example.hellomvp.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    LoginContract.Presenter presenter;
    LoginRepository loginRepository;

    EditText emailEt;
    EditText passwordEt;
    Button loginBt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBt = findViewById(R.id.loginBt);

        loginRepository =  new LoginRepository();

        presenter = new LoginPresenter(this, loginRepository);

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickEmailLogin2();
            }
        });
    }

    @Override
    public String getInputEmail() {
        return emailEt.getText().toString();
    }

    @Override
    public void showMessageNotEnterEmail() {
        Toast.makeText(this, "이메일을 입력하세요", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getInputPassword() {
        return passwordEt.getText().toString();
    }

    @Override
    public void showMessageNotEnterPassword() {
        Toast.makeText(this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageIncorrectEmail() {
        Toast.makeText(this, "잘못된 이메일 형식입니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageIncorrectPassword() {
        Toast.makeText(this, "잘못된 비밀번호 형식입니다", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageFailLogin(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveActivity() {

    }
}
