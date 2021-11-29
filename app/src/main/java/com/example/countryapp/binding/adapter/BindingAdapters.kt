package com.example.countryapp.binding.adapter


import android.widget.ImageView

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.countryapp.adapter.CountryAdapter
import com.example.countryapp.model.Country


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl.let {
        val imageLoader = ImageLoader.Builder(imgView.context)
            .componentRegistry { add(SvgDecoder(imgView.context)) }
            .build()

        val request = ImageRequest.Builder(imgView.context)
            .data(imgUrl)
            .target(imgView)
            .build()

        imageLoader.enqueue(request)
    }


}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Country>?){

    val adapter = recyclerView.adapter as CountryAdapter
    adapter.submitList(data)
}