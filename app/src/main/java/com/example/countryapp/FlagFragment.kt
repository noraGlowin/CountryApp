package com.example.countryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.countryapp.adapter.CountryAdapter
import com.example.countryapp.databinding.FragmentFlagBinding
import com.example.countryapp.viewmodel.CountryViewModel


class FlagFragment : Fragment() {
    private val countryViewModel: CountryViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFlagBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.countryViewModel = countryViewModel
        binding.recyclerView.adapter = CountryAdapter()
        return binding.root

    }




}