package com.example.hellomvp;

import com.example.hellomvp.Activity.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    //Rule 정의.
    // Test 어노테이션이 붙은 메소드가 실행이 될 때, 해당 액티비티가 생성됨.
    @Rule
    public ActivityTestRule<LoginActivity> loginActivityRule = new ActivityTestRule(LoginActivity.class, true, true);

    @Test
    public void test_NotEnterEmail(){

        //화면에 이메일,비밀번호 입력란이 보이는지 체크
        onView(withId(R.id.emailEt)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordEt)).check(matches(isDisplayed()));

        //로그인 버튼 클릭
        onView(withId(R.id.loginBt)).perform(click());

        //이메일 입력 메세지 표시
        onView(withText("이메일을 입력하세요")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void test_NotEnterPassword(){

        //화면에 이메일,비밀번호 입력란이 보이는지 체크
        onView(withId(R.id.emailEt)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordEt)).check(matches(isDisplayed()));

        //이메일 입력
        onView(withId(R.id.emailEt)).perform(typeText("tony.stark@starkinc.com"));

        //로그인 버튼 클릭
        onView(withId(R.id.loginBt)).perform(click());

        //비밀번호 입력 메세지 표시
        onView(withText("비밀번호를 입력하세요")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void test_EnterInvalidEmail(){

        //화면에 이메일,비밀번호 입력란이 보이는지 체크
        onView(withId(R.id.emailEt)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordEt)).check(matches(isDisplayed()));

        //이메일, 비밀번호 입력
        onView(withId(R.id.emailEt)).perform(typeText("tony.stark@starkinc"));
        onView(withId(R.id.passwordEt)).perform(typeText("imgroooot123!@"));

        //로그인 버튼 클릭
        onView(withId(R.id.loginBt)).perform(click());

        //이메일 형식 오류 메세지 표시
        onView(withText("잘못된 이메일 형식입니다")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void test_SuccessEmailLogin(){

        //화면에 이메일,비밀번호 입력란이 보이는지 체크
        onView(withId(R.id.emailEt)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordEt)).check(matches(isDisplayed()));

        //입력란에 이메일, 비밀번호를 입력
        onView(withId(R.id.emailEt)).perform(typeText("tony.stark@starkinc.com"));
        onView(withId(R.id.passwordEt)).perform(typeText("imgroooot123!@"));

        //로그인 버튼 클릭
        onView(withId(R.id.loginBt)).perform(click());

        //로그인 성공 메세지 표시
        onView(withText("로그인 성공")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void test_FailEmailLogin(){
        //화면에 이메일,비밀번호 입력란이 보이는지 체크
        onView(ViewMatchers.withId(R.id.emailEt)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.passwordEt)).check(matches(isDisplayed()));

        //입력란에 이메일, 비밀번호를 입력
        onView(withId(R.id.emailEt)).perform(typeText("tony.stark@starkinc.com"));
        onView(withId(R.id.passwordEt)).perform(typeText("imsteverogers123!@"));

        //로그인 버튼 클릭
        onView(withId(R.id.loginBt)).perform(click());

        //로그인 실패 메세지 표시
        onView(withText("로그인 실패")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    @Test
    public void test_NotRegistedEmail(){
        //화면에 이메일,비밀번호 입력란이 보이는지 체크
        onView(ViewMatchers.withId(R.id.emailEt)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.passwordEt)).check(matches(isDisplayed()));

        //입력란에 이메일, 비밀번호를 입력
        onView(withId(R.id.emailEt)).perform(typeText("steve.rogers@starkinc.com"));
        onView(withId(R.id.passwordEt)).perform(typeText("imsteverogers123!@"));

        //로그인 버튼 클릭
        onView(withId(R.id.loginBt)).perform(click());

        //로그인 실패 메세지 표시
        onView(withText("앗 성공해버림")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }
}
