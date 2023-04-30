package com.nailorsh.fuels.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

/*
interface CityApi {
    @GET("cities")
    suspend fun getAllCities(@Query("_page") page: Int): List<City>
}
*/

interface CityApi {
    @GET("cities")
    suspend fun getAllCities(): List<City>
}

/*
fun interface CityApi {
    @GET("cities/1")
    suspend fun getCityById(): City
}

/*
interface MyApiService {
    @GET("cities")
    fun getItems(): List<Item>
}
 */