package com.example.hellomvp.Model;

import com.example.hellomvp.Contract.LoginContract;

public class LoginRepository implements LoginContract.Repository {
    @Override
    public void login(String email, String password, LoginCallbackListener callback) {
        if(email.equals("tony.stark@starkinc.com")){
            if(password.equals("imgroooot123!@")){
                callback.onSuccess(new User());
            }else{
                callback.onFailure(1234, "로그인 실패");
            }
        }else{
            callback.onFailure(4444, "등록되지 않은 회원입니다");
        }
    }

    public interface LoginCallbackListener{
        void onSuccess(User user);
        void onFailure(Integer errorCode, String message);
    }
}
