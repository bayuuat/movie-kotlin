package com.example.challengelima.user

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
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
        val user = database.get(email, pass)
        return user
    }

    fun getUser(id: Long): User? {
        return database.getUserbyId(id)
    }

    fun registerUser(username: String, email: String, password: String) {
        viewModelScope.launch {
            val user = User(userName = username, userEmail = email, userPassword = password)
            database.insert(user)
        }
    }

    fun updateUser(username: String, email: String, password: String, id: Long) {
        viewModelScope.launch {
            val user = User(userId = id, userName = username, userEmail = email, userPassword = password)
            Log.d("USER_JSON", user.toString())
            database.update(user)
        }
    }
}

