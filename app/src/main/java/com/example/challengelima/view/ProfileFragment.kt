package com.example.challengelima.view

import android.os.Bundle
import android.util.Log
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
import com.example.challengelima.database.user.User
import com.example.challengelima.databinding.FragmentProfileBinding
import com.example.challengelima.user.UserViewModel
import com.example.challengelima.user.UserViewModelFactory

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding
    private lateinit var sharedPref: MainSharedPref
    private lateinit var viewModel: UserViewModel
    private lateinit var userJson: User



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupUI()

        binding?.btnLogout?.setOnClickListener {
            sharedPref.isLogin = false
            findNavController().navigate(R.id.action_logout)
        }

        val application = requireNotNull(this.activity).application
        val dataSource = MainDatabase.getInstance(application).userDatabaseDao
        val viewModelFactory = UserViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[UserViewModel::class.java]

        binding?.btnUpdate?.setOnClickListener {
            if (binding!!.etPass.text.toString() == binding!!.etRePass.text.toString()){
                viewModel.updateUser(
                    binding!!.etUsername.text.toString(),
                    binding!!.etEmail.text.toString(),
                    binding!!.etPass.text.toString(),
                    userJson.userId
                )
                Log.d("USER", userJson.toString())
                findNavController().popBackStack()
                findNavController().navigate(R.id.homeFragment)
            } else {
                Toast.makeText(requireActivity(), "Password not match", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun setupUI(){
        sharedPref = MainSharedPref(requireActivity())
        val user = sharedPref.loggedUser
        val application = requireNotNull(this.activity).application
        val dataSource = MainDatabase.getInstance(application).userDatabaseDao
        val viewModelFactory = UserViewModelFactory(dataSource, application)
        val userViewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[UserViewModel::class.java]

        userJson = userViewModel.getUser(user)!!

        binding?.etUsername?.setText(userJson?.userName)
        binding?.etEmail?.setText(userJson?.userEmail)
        binding?.etPass?.setText(userJson?.userPassword)
    }
}