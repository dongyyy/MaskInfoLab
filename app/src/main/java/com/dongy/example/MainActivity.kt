package com.dongy.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dongy.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //https://developer.android.com/topic/libraries/architecture/viewmodel?hl=ko
        val viewModel: MainViewModel by viewModels()
        var storeAdapter = StoreAdapter()

        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    RecyclerView.VERTICAL,
                    false
                )

            adapter = storeAdapter
        }


// live data
//        viewModel.fetchStoreInfo().observe(this, Observer {
//            storeAdapter.storeList = it
//            supportActionBar!!.title = "마스크 재고 있는 곳: ${it.size}곳"
//        })


// rx
        viewModel.fetchStoreInfo().subscribe { it -> storeAdapter.storeList = it
            supportActionBar!!.title = "마스크 재고 있는 곳: ${it.size}곳"}

    }

}

