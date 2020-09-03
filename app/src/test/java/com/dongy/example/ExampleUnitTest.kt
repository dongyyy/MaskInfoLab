package com.dongy.example

import org.junit.Assert.assertEquals
import org.junit.Test

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
