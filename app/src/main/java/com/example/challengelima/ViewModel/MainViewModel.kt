package com.example.challengelima.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challengelima.MainDatabase
import com.example.challengelima.MainSharedPref
import com.example.challengelima.database.user.User
import com.example.challengelima.user.UserViewModel
import com.example.challengelima.user.UserViewModelFactory

class MainViewModel:  ViewModel() {
    private val _isLogin: MutableLiveData<Boolean> = MutableLiveData()
    val isLogin: LiveData<Boolean> get() = _isLogin

    fun setLogin(value: Boolean){
        _isLogin.postValue(value)
    }
}