package com.dongy.example.repository

import com.google.gson.JsonElement
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MaskService {
    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/junsuk5/bb7485d5f70974deee920b8f0cd1e2f0/raw/063f64d9b343120c2cb01a6555cf9b38761b1d94/"
    }

    @GET("sample.json")
    fun fetchStoreInfo(): Single<JsonElement>
//    fun fetchStoreInfo() : Single<StoreInfo>
//    fun fetchStoreInfo() : Call<StoreInfo>
}
