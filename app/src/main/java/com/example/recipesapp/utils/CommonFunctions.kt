package com.example.recipesapp.utils


import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.core.util.PatternsCompat
import com.example.recipesapp.R
import java.util.regex.Pattern

@SuppressLint("InflateParams")
fun Context.createAlertDialog(activity: Activity): Dialog {
    val dialogTransparent = Dialog(this,  android.R.style.Theme_Black)
    val view: View = LayoutInflater.from(activity).inflate(
        R.layout.progress_dialog, null
    )
    dialogTransparent.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialogTransparent.window?.setBackgroundDrawableResource(
        R.color.transparent
    )

    dialogTransparent.setCancelable(false)
    dialogTransparent.setContentView(view)
    return dialogTransparent
}

fun isValidEmailAndPassword(email: String, password: String): Resource<String, String> {
    return if (email.isEmpty()) {
        Resource.Error("email can't be empty !")
    } else if (!isValidEmail(email)) {
        Resource.Error("please enter a valid email !")
    } else if (password.isEmpty()) {
        Resource.Error("password can't be empty !")
    } else if (!isValidPasswordFormat(password)) {
        Resource.Error("please enter a valid password !")
    } else {
        Resource.Success("valid User")
    }
}

fun isValidEmail(email: String): Boolean {
    return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
}

fun isValidPasswordFormat(password: String): Boolean {
    val passwordRegex = Pattern.compile(
        "^" +
                "(?=.*[0-9])" + // at least 1 digit
                "(?=.*[a-z])" + // at least 1 lower case letter
                "(?=.*[A-Z])" + // at least 1 upper case letter
                "(?=.*[@#$%^&+=])" + // at least 1 special character
                "(?=\\S+$)" + // no white spaces
                ".{6,}" + // at least 6 characters
                "$"
    )
    return passwordRegex.matcher(password).matches()
}