package com.example.feature_home.view

import MainAdapter
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengelima.MainDatabase
import com.example.challengelima.api.ApiClient
import com.example.challengelima.model.Movie
import com.example.challengelima.model.Movies
import com.example.data.MainSharedPref
import com.example.data.api.ApiKey
import com.example.data.database.user.UserViewModel
import com.example.data.database.user.UserViewModelFactory
import com.example.feature_home.R
import com.example.feature_home.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var sharedPref: MainSharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val application = requireNotNull(this.activity).application
        init(application)
        fetchAllData()

        binding?.btnProfile?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
    }

    fun init(context: Context){
        sharedPref = MainSharedPref(context)
        val user = sharedPref.loggedUser
        val application = requireNotNull(this.activity).application
        val dataSource = MainDatabase.getInstance(application).userDatabaseDao
        val viewModelFactory = UserViewModelFactory(dataSource, application)
        val userViewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[UserViewModel::class.java]

        val getUser = userViewModel.getUser(user)

        binding?.tvUsername?.text = getUser?.userName
    }

    private fun fetchAllData(){
        ApiClient.apiClient.getTrendingMovie( "movie", ApiKey.apiKeyTMDB)
            .enqueue(object : Callback<Movies>{
                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    val getMovie = response.body()
                    val listMovie = getMovie?.results

                    val adapter =  MainAdapter(
                        listMovie,
                        context,
                        onClick = {sendData(it, listMovie)}
                    )

                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                    val recyclerView = binding?.rvTrendMovie

                    recyclerView?.layoutManager = layoutManager
                    recyclerView?.adapter = adapter
                }

                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    Log.e("MANTAP", t.message.toString())
                }

            })
        ApiClient.apiClient.getTrendingMovie("tv",ApiKey.apiKeyTMDB)
            .enqueue(object : Callback<Movies>{
                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    val getMovie = response.body()
                    val listMovie = getMovie?.results

                    val adapter =  MainAdapter(
                        listMovie,
                        context,
                        onClick = {sendData(it, listMovie)}
                    )

                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                    val recyclerView = binding?.rvTrendSeries

                    recyclerView?.layoutManager = layoutManager
                    recyclerView?.adapter = adapter
                }

                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    Log.e("MANTAP", t.message.toString())
                }

            })
    }

    private fun sendData(position: Int, list: List<Movie?>?){
        val movie = list?.get(position)
        val bundle = Bundle()
        bundle.putSerializable("SELECTED_MOVIE", movie)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }
}