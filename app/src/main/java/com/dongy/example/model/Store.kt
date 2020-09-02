package com.dongy.example.model

import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("addr")
    val addr: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("remain_stat")
    val remainStat: String,
    @SerializedName("stock_at")
    val stockAt: String,
    @SerializedName("type")
    val type: String
)