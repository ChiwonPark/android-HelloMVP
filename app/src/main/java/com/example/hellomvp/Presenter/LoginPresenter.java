package com.example.hellomvp.Presenter;

import android.text.TextUtils;

import com.example.hellomvp.Contract.LoginContract;
import com.example.hellomvp.Model.LoginRepository;
import com.example.hellomvp.Model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPresenter implements LoginContract.Presenter {
    LoginContract.View view;
    LoginRepository repository;

    public LoginPresenter(LoginContract.View view, LoginRepository repository){
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onClickEmailLogin() {

        String inputEmail = view.getInputEmail();
        String inputPassword = view.getInputPassword();

        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        //최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(inputEmail);

        if(!emailMatcher.matches()){
            view.showMessageIncorrectEmail();
            return;
        }

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(inputPassword);

        if(!passwordMatcher.matches()){
            view.showMessageIncorrectPassword();
            return;
        }
    }

    @Override
    public void onClickEmailLogin2() {
        String inputEmail = view.getInputEmail();
        String inputPassword = view.getInputPassword();

        if(TextUtils.isEmpty(inputEmail)){
            view.showMessageNotEnterEmail();
            return;
        }else if(TextUtils.isEmpty(inputPassword)){
            view.showMessageNotEnterPassword();
            return;
        }

        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$"; //최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(inputEmail);

        if(!emailMatcher.matches()){
            view.showMessageIncorrectEmail();
            return;
        }

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(inputPassword);

        if(!passwordMatcher.matches()){
            view.showMessageIncorrectPassword();
            return;
        }

        view.hideSoftKeyboard();
        view.showLoadingDialog();

        repository.login(inputEmail, inputPassword, new LoginRepository.LoginCallbackListener() {
            @Override
            public void onSuccess(User user) {
                view.hideLoadingDialog();
                view.showMessageSuccessLogin();
                view.moveActivity();
            }

            @Override
            public void onFailure(Integer errorCode, String message) {
                view.hideLoadingDialog();
                view.showMessageFailLogin(message);
            }
        });
    }
}
