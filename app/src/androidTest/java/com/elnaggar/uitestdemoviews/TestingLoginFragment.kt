package com.elnaggar.uitestdemoviews

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TestingLoginFragment {


    @Test
    fun insertEmailAndPassword_performLogin_assertEditTextIsEmpty() {
        //Arrange
        val email = "a@a.com"
        val password = "123"
        launchFragmentInContainer<LoginFragment>()
        onView(withId(R.id.emailEditText)).perform(typeText(email))
        onView(withId(R.id.passwordEditText)).perform(typeText(password))
        //Action
        onView(withId(R.id.loginButton)).perform(click())
        //Assert
        onView(withId(R.id.emailEditText)).check(matches(ViewMatchers.withText("")))
        onView(withId(R.id.passwordEditText)).check(matches(ViewMatchers.withText("")))
    }

    @Test
    fun insertNotValidEmailAndPassword_performLogin_assertEditTextIsNotEmpty() {
        //Arrange
        val email = "com"
        val password = "123"
        launchFragmentInContainer<LoginFragment>()
        onView(withId(R.id.emailEditText)).perform(typeText(email))
        onView(withId(R.id.passwordEditText)).perform(typeText(password))
        //Action
        onView(withId(R.id.loginButton)).perform(click())
        //Assert
        onView(withId(R.id.emailEditText)).check(matches(ViewMatchers.withText(email)))
        onView(withId(R.id.passwordEditText)).check(matches(ViewMatchers.withText(password)))
    }


}