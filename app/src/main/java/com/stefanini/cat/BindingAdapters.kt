package com.stefanini.cat

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.stefanini.cat.network.parser.Image

@BindingAdapter("app:imageUrl")
fun bindImage(imgView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri){
           // placeholder(R.drawable.)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("app:listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<Image>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)

}