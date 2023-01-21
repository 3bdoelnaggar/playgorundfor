package com.elnaggar.uitestdemoviews

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ValidatorKtTest {


    @Test
    fun notValidEmail_returnFalse() {
        val email = "abdalla"

       assert(!email.isValidEmail())

    }

    @Test
    fun validEmail_returnTrue() {
        val email = "abdalla@abdalla.com"
        assert(email.isValidEmail())
    }

    @Test
    fun emptyEmail_returnFalse() {
        val email = ""
        assert(!email.isValidEmail())
    }

    @Test
    fun blankEmail_returnFalse() {
        val email = " "
        assert(!email.isValidEmail())
    }
}