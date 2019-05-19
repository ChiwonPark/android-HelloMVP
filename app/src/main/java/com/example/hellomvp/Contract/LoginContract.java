package com.example.hellomvp.Contract;

import com.example.hellomvp.Model.LoginRepository;

public interface LoginContract {
    interface View{
        String getInputEmail();
        void showMessageNotEnterEmail();
        void showMessageIncorrectEmail();
        String getInputPassword();
        void showMessageNotEnterPassword();
        void showMessageIncorrectPassword();
        void hideSoftKeyboard();
        void showLoadingDialog();
        void hideLoadingDialog();
        void showMessageSuccessLogin();
        void showMessageFailLogin(String errorMsg);
        void moveActivity();
    }

    interface Presenter{
        void setView(View view);
        void onClickEmailLogin();
        void onClickEmailLogin2();
    }

    interface Repository{
        void login(String email, String password, LoginRepository.LoginCallbackListener callback);
    }
}
