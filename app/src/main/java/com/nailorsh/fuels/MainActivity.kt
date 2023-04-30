package com.nailorsh.fuels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nailorsh.fuels.data.retrofit.CityApi
import com.nailorsh.fuels.theme.SelectionCityScreen
import com.nailorsh.fuels.theme.StartSplashScreen
import com.nailorsh.fuels.ui.theme.FuelsTheme
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/nikvoen/server/")
            .addConverterFactory(MoshiConverterFactory.create()).build()
        val cityApi = retrofit.create(CityApi::class.java)

        setContent {
            FuelsTheme {
                StartSplashScreen()
//                SelectionCityScreen()
                FuelsApp()
            }
        }
    }
}