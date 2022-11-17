package com.example.challengelima.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.challengelima.MainDatabase
import com.example.challengelima.MainSharedPref
import com.example.challengelima.R
import com.example.challengelima.database.user.User
import com.example.challengelima.databinding.FragmentHomeBinding
import com.example.challengelima.databinding.FragmentProfileBinding
import com.example.challengelima.user.UserViewModel
import com.example.challengelima.user.UserViewModelFactory
import com.google.gson.Gson

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding
    private lateinit var sharedPref: MainSharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = view.context
        setup(context)
        binding?.btnLogout?.setOnClickListener {
            sharedPref.isLogin = false
            findNavController().navigate(R.id.action_logout)
        }
    }

    private fun setup(context: Context){
        sharedPref = MainSharedPref(context)
        val user = sharedPref.loggedUser
        val userJson = Gson().fromJson(user, User::class.java)

        binding?.etUsername?.setText(userJson.userName)
        binding?.etEmail?.setText(userJson.userEmail)
        binding?.etPass?.setText(userJson.userPassword)
    }
}