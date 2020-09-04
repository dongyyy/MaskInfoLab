package com.dongy.example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dongy.example.model.Store
import com.dongy.example.repository.MaskService
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val TAG = MainViewModel::class.simpleName

    var storeListLiveData: MutableLiveData<List<Store>> = MutableLiveData()

    private val gson =
        GsonBuilder()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(MaskService.BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val service = retrofit.create(MaskService::class.java)

// live data
//    fun fetchStoreInfo() : MutableLiveData<List<Store>> {
//        service.fetchStoreInfo()
//            .map {
//                it.asJsonObject.getAsJsonArray("stores")
//                    .map { stores ->
//                        gson.fromJson(stores, Store::class.java)!!
//                    }.filter { store -> store.remainStat != null }
//            }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .doOnError { e -> e.printStackTrace() }
//            .subscribe { it -> storeListLiveData.value = it }
//            //postValue 백그라운드, setValue 메인스레드
//            //.observeOn(AndroidSchedulers.mainThread()) 지우고, setValue 호출 시 exception 발생 java.lang.IllegalStateException: Cannot invoke setValue on a background thread
//            //.observeOn(AndroidSchedulers.mainThread()) 지우고, postValue 호출 시 잘 동작
//            //.observeOn(AndroidSchedulers.mainThread()) 안지우고 setValue 호출 시 잘 동작
//            //.observeOn(AndroidSchedulers.mainThread()) 안지우고 postValue 호출 시 잘 동작
//            //https://wooooooak.github.io/android/2019/06/11/Android_liveData_value/
//
//        return storeListLiveData
//    }

// Rx
    fun fetchStoreInfo(): Single<List<Store>> {
        return service.fetchStoreInfo()
            .map {
                it.asJsonObject.getAsJsonArray("stores")
                    .map { stores ->
                        gson.fromJson(stores, Store::class.java)!!
                    }.filter { store -> store.remainStat != null }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { e -> e.printStackTrace() }
    }
}
