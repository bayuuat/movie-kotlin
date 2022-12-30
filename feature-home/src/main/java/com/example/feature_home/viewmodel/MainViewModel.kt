package com.example.feature_home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challengelima.MainDatabase

class MainViewModel:  ViewModel() {
    private val _isLogin: MutableLiveData<Boolean> = MutableLiveData()
    val isLogin: LiveData<Boolean> get() = _isLogin

    fun setLogin(value: Boolean){
        _isLogin.postValue(value)
    }
}