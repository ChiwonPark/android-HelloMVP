package com.example.hellomvp;

import com.example.hellomvp.Contract.LoginContract;
import com.example.hellomvp.Model.LoginRepository;
import com.example.hellomvp.Model.User;
import com.example.hellomvp.Presenter.LoginPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Mock
    LoginContract.View view;

    LoginContract.Presenter presenter;

    @Mock
    LoginRepository repository;

    @Captor
    ArgumentCaptor<LoginRepository.LoginCallbackListener> callbackListener;

    InOrder inOrder;

    @Before
    public void setup(){
        presenter = new LoginPresenter(view, repository);
        inOrder = Mockito.inOrder(view, repository);
    }

    @Test
    public void test_onClickEmailLogin_fail_EnterIncorrectEmail(){
        //잘못된 이메일 형식을 입력
        Mockito.when(view.getInputEmail()).thenReturn("tony.stark@starkinc");

        //로그인버튼 클릭
        presenter.onClickEmailLogin();

        //오류메세지 출력
        Mockito.verify(view).showMessageIncorrectEmail();
    }

    @Test
    public void test_onClickEmailLogin_fail_EnterIncorrectPassword(){
        //정상적인 이메일 형식 입력
        Mockito.when(view.getInputEmail()).thenReturn("tony.stark@starkinc.com");

        //잘못된 패스워드 형식 입력
        Mockito.when(view.getInputPassword()).thenReturn("123");

        //로그인버튼 클릭
        presenter.onClickEmailLogin();

        //오류메세지 출력
        Mockito.verify(view).showMessageIncorrectPassword();
    }

    @Test
    public void test_onClickEmailLogin_SuccessLogin(){
        User mockUser = Mockito.mock(User.class);

        //정상적인 이메일, 패스워드 입력
        Mockito.when(view.getInputEmail()).thenReturn("tony.stark@starkinc.com");
        Mockito.when(view.getInputPassword()).thenReturn("123asdsada@!@as");

        //로그인 버튼 클릭
        presenter.onClickEmailLogin2();

        //키보드 숨기고, 로딩표시
        inOrder.verify(view).hideSoftKeyboard();
        inOrder.verify(view).showLoadingDialog();

        String email = view.getInputEmail();
        String password = view.getInputPassword();

        inOrder.verify(repository).login(Mockito.eq(email),Mockito.eq(password), callbackListener.capture());
        callbackListener.getValue().onSuccess(mockUser);

        inOrder.verify(view).showMessageSuccessLogin();
        inOrder.verify(view).moveActivity();
    }

    @Test
    public void test_onClickEmailLogin_FailLogin(){
        //정상적인 이메일, 패스워드 입력
        Mockito.when(view.getInputEmail()).thenReturn("tony.stark@starkinc.com");
        Mockito.when(view.getInputPassword()).thenReturn("123asdsada@!@as");

        Integer errorCode = 4444;
        String errorMessage = "toyn is gone.";

        //로그인 버튼 클릭
        presenter.onClickEmailLogin2();

        //키보드 숨기고, 로딩표시
        inOrder.verify(view).hideSoftKeyboard();
        inOrder.verify(view).showLoadingDialog();

        String email = view.getInputEmail();
        String password = view.getInputPassword();

        inOrder.verify(repository).login(Mockito.eq(email),Mockito.eq(password), callbackListener.capture());
        callbackListener.getValue().onFailure(errorCode, errorMessage);

        inOrder.verify(view).hideLoadingDialog();
        inOrder.verify(view).showMessageFailLogin(errorMessage);
    }
}
