package com.example.hellomvp.Model;

import com.example.hellomvp.Contract.LoginContract;

public class LoginRepository implements LoginContract.Repository {
    @Override
    public void login(String email, String password, LoginCallbackListener callback) {

    }

    public interface LoginCallbackListener{
        void onSuccess(User user);
        void onFailure(Integer errorCode, String message);
    }
}
