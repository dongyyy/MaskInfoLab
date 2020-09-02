package com.dongy.example

import android.util.Log
import com.dongy.example.model.Store
import com.dongy.example.model.StoreInfo
import com.dongy.example.repository.MaskService
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun retrofitTest() {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(MaskService.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(MaskService::class.java)
//
//        val storeInfoCall = service.fetchStoreInfo()
//        //여기까지 데이터 받아올 준비 끝
//
//        var storeInfo = storeInfoCall.execute().body()
//
//        assertEquals(222, storeInfo?.count)
//        assertEquals(222, storeInfo?.stores?.size)
    }

}