package com.dongy.example.model

import com.google.gson.annotations.SerializedName

data class StoreInfo(
    @SerializedName("count")
    val count: Int,
    @SerializedName("stores")
    val stores: List<Store>
)