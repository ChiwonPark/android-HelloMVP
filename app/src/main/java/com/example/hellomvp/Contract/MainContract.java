package com.example.hellomvp.Contract;

/**
 * 뷰, 프리젠터, 모델이 가지는 기능을 정의한다.
 */
public interface MainContract {

    interface Presenter{
        void setView(View view);
        void add(int num);
        String getCounter();
    }

    interface View{
        void updateCount();
    }
}






