package com.stefanini.cat

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.stefanini.cat.network.parser.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers


val   fetchURL = " https://api.imgur.com/3/gallery/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(fetchURL).build()

object ImgApi {
    val retrofitService : ImgService by lazy {
        retrofit.create(ImgService::class.java) }
}

interface ImgService {
    @Headers("Authorization: Client-ID 1ceddedc03a5d71")
    @GET("search/?q_all=cat&q_type=jpg")
    suspend fun getPhotos(): Response
}