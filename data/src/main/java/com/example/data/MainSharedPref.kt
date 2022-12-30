package com.example.data

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

    var loggedUser: Long
        set(value) {
            preference.edit{
                putLong("LOGGED_USER", value)
            }
        }
        get() = preference.getLong("LOGGED_USER", 0)

}