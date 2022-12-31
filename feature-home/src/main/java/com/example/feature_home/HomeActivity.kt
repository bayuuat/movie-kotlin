package com.example.feature_home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feature_home.view.HomeFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, HomeFragment())
//                .commitNow()
//        }
    }
}