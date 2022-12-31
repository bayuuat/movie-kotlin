package com.example.challengelima.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.challengelima.MainDatabase
import com.example.challengelima.R
import com.example.challengelima.databinding.FragmentLoginBinding
import com.example.data.MainSharedPref
import com.example.data.database.user.UserViewModel
import com.example.data.database.user.UserViewModelFactory
import com.example.feature_home.HomeActivity


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding?=null
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
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(requireActivity(), "Wrong Credentials", Toast.LENGTH_LONG).show()
            }
        }

        if (sharedPref.isLogin){
            val intent = Intent(activity, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            requireActivity().finish();
        }

        binding?.ctaToRegister?.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun setup(context: Context){
        sharedPref = MainSharedPref(context)
    }

}