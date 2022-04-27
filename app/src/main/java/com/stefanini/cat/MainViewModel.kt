package com.stefanini.cat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stefanini.cat.network.parser.Image
import kotlinx.coroutines.*




class MainViewModel() : ViewModel() {

     private   var _listaResponse = MutableLiveData<List<Image>>()
     val listaResponse: LiveData<List<Image>> = _listaResponse

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    fun launchDataLoad() {
        uiScope.launch {
            try {
                fetchList();
            } catch (e: Exception) {
                println("erro " + e.message)
               // listaResponse.postValue()
               // _title_1.postValue(e.message)
            }

        }
    }

    suspend fun fetchList() = withContext(Dispatchers.Default) {
        val lista = ImgApi.retrofitService.getPhotos()
        val list = mutableListOf<Image>()
        for (photos in lista.data) {
            if( photos.images != null) {
                for (image in photos.images!!) {
                    if (image.type.contains("image")) {
                        //_listaResponse.postValue(photos.images);
                        list.add(image);
                        break
                    }
                }
            }
       }
        _listaResponse.postValue(list);
    }



}

