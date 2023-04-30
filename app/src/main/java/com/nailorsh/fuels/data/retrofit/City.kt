package com.nailorsh.fuels.data.retrofit

data class City (
    val id: Int,
    val name: String,
    val prices: Map<String, List<Double>>
)
