package com.example.countryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryapp.model.Country
import java.lang.Exception



import com.example.countryapp.network.CountryApi
import kotlinx.coroutines.launch


class CountryViewModel: ViewModel() {

    private var _country = MutableLiveData<String>()
    val country: LiveData<String> = _country
    private var _countryPhotos = MutableLiveData<List<Country>>()
    val countryPhotos: LiveData<List<Country>> = _countryPhotos

    init {
        getCountryPhoto()
    }


    fun getCountryPhoto() {
        viewModelScope.launch {
            try {
                _countryPhotos.value = CountryApi.retrofitService.getPhoto().data
                _country.value = "Success"

            }catch (e: Exception){
                _country.value = "Failure: ${e.message}"
            }
        }

    }
}