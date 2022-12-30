package com.example.feature_home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.challengelima.model.Movie
import com.example.feature_home.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding?=null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = view.getContext();
        super.onViewCreated(view, savedInstanceState)

        binding?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }

        val data = getDetail()
        binding?.tvDetailTitle?.text = if (data.title != null) data.title else data.name
        binding?.tvDetailStar?.text = String.format("%.2f", data.vote_average)
        binding?.tvOverview?.text = data.overview
        binding?.imgDetailPoster?.let {
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500${data.poster_path}")
                .into(it)
        }
        binding?.imgBackdrop?.let {
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500${data.backdrop_path}")
                .into(it)
        }

    }

    fun getDetail(): Movie {
        val movie = arguments?.getSerializable("SELECTED_MOVIE") as Movie

        return movie;
    }

}