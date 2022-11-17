package com.example.challengelima

import android.content.Context
import androidx.core.content.edit
import com.example.challengelima.database.user.User

class MainSharedPref(context: Context) {

    private val sharedName = "SharedPreference"
    private var preference = context.getSharedPreferences(sharedName, Context.MODE_PRIVATE)

    var isLogin: Boolean
        set(value) {
            preference.edit{
                putBoolean("IS_LOGIN", value)
            }
        }
        get() = preference.getBoolean("IS_LOGIN", false)

    var loggedUser: String?
        set(value) {
            preference.edit{
                putString("LOGGED_USER", value)
            }
        }
        get() = preference.getString("LOGGED_USER", "")
}