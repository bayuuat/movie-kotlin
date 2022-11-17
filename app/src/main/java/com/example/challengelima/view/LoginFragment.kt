package com.example.challengelima.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.challengelima.MainDatabase
import com.example.challengelima.MainSharedPref
import com.example.challengelima.R
import com.example.challengelima.ViewModel.MainViewModel
import com.example.challengelima.databinding.FragmentLoginBinding
import com.example.challengelima.user.UserViewModel
import com.example.challengelima.user.UserViewModelFactory
import com.google.gson.Gson

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding
    private lateinit var sharedPref: MainSharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = requireNotNull(activity).application
        setup(context)
        val application = requireNotNull(this.activity).application
        val dataSource = MainDatabase.getInstance(application).userDatabaseDao
        val viewModelFactory = UserViewModelFactory(dataSource, application)
        val userViewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[UserViewModel::class.java]

        binding?.btnLogin?.setOnClickListener {
            val user = userViewModel.loginUser(
                binding!!.etLoginEmail.text.toString(),
                binding!!.etLoginPass.text.toString()
            )
            if (user != null) {
                sharedPref.isLogin = true
                sharedPref.loggedUser = user.userId
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
            } else {
                Toast.makeText(requireActivity(), "Wrong Credentials", Toast.LENGTH_LONG).show()
            }
        }

        if (sharedPref.isLogin){
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
        }

        binding?.ctaToRegister?.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun setup(context: Context){
        sharedPref = MainSharedPref(context)
    }

}