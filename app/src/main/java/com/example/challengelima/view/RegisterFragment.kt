package com.example.challengelima.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.challengelima.MainDatabase
import com.example.challengelima.R
import com.example.challengelima.databinding.FragmentRegisterBinding
import com.example.data.database.user.UserViewModel
import com.example.data.database.user.UserViewModelFactory

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(this.activity).application
        val dataSource = MainDatabase.getInstance(application).userDatabaseDao
        val viewModelFactory = UserViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[UserViewModel::class.java]

        binding.btnRegister.setOnClickListener {
            viewModel.registerUser(
                binding.etRegisterUsername.text.toString(),
                binding.etRegisterEmail.text.toString(),
                binding.etRegisterPassword.text.toString()
            )
            findNavController().popBackStack()
            findNavController().navigate(R.id.loginFragment)
        }
    }
}