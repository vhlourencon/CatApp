package com.stefanini.cat

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.stefanini.cat.databinding.ActivityMainBinding
import com.stefanini.cat.network.parser.Image


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main);
        setContentView(binding.root)


        val model: MainViewModel by  viewModels()
        binding.photosGrid.adapter = PhotoGridAdapter()
        binding.viewModel = model
        binding.lifecycleOwner = this



        val responseObserver = Observer<List<Image>> { response ->
                for ( image in response) {
                    println(image.link)
                   // binding.marsImag.
                }
        }


        model.listaResponse.observe(this, responseObserver)
        model.launchDataLoad();




    }










}