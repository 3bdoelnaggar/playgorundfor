package com.elnaggar.uitestdemoviews

import android.util.Patterns


fun CharSequence?.isValidEmail() =
    !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()