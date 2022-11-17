package com.example.challengelima.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.challengelima.database.user.User
import com.example.challengelima.database.user.UserDatabaseDao
import kotlinx.coroutines.launch

/**
 * ViewModel for SleepTrackerFragment.
 */
class UserViewModel(
        val database: UserDatabaseDao,
        application: Application) : AndroidViewModel(application) {

    fun loginUser(email: String, pass: String): User? {
        var user = database.get(email, pass)
        return user
    }

    fun registerUser(username: String, email: String, password: String) {
        viewModelScope.launch {
            val user = User(userName = username, userEmail = email, userPassword = password)
            database.insert(user)
        }
    }
}

