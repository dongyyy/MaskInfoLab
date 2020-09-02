package com.dongy.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://developer.android.com/topic/libraries/architecture/viewmodel?hl=ko
        val viewModel: MainViewModel by viewModels()
        var storeAdapter = StoreAdapter()

        recycler_view.apply {
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

