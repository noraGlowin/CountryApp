package com.example.countryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapp.databinding.CountryItemBinding
import com.example.countryapp.model.Country

class CountryAdapter: androidx.recyclerview.widget.ListAdapter<Country, CountryAdapter.CountryViewHolder>(DiffCallback) {

    class CountryViewHolder(private val binding: CountryItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(countryPhoto: Country) {
            binding.countryModel = countryPhoto
            binding.executePendingBindings()
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(CountryItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val flagPhoto = getItem(position)
        println(flagPhoto.flag)
        holder.bind(flagPhoto)
    }


    companion object DiffCallback: DiffUtil.ItemCallback<Country>(){
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.flag == newItem.flag
        }

    }
}