package com.nailorsh.fuels.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nailorsh.fuels.data.retrofit.CityApi
import com.nailorsh.fuels.ui.theme.BrandColor
import kotlinx.coroutines.runBlocking


fun getAllCities(cityApi: CityApi): List<String> {
    val cities = mutableListOf<String>()
    val allCities = runBlocking { cityApi.getAllCities() }

    for (city in allCities) {
        cities.add(city.name)
    }

    return cities
}

@Composable
fun SelectionCityScreen(
    onListItemClicked: (String) -> Unit = {},
//    onDownloadData: (String) -> Unit = {},
//    citiesList: List<String>,
    cityApi: CityApi
) {

    val citiesList = getAllCities(cityApi)
//    val citiesList = listOf(
//        "Москва",
//        "Питер",
//        "Новосиб",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55",
//        "55"
//    )

    Scaffold { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),

            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(citiesList) { city ->
                Button(
                    onClick = {
                        onListItemClicked(city)
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Text(
                        text = city,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        color = BrandColor
                    )
                }
            }
        }
    }
}

//@Preview(
//    name = "SelectionCityScreenPreview",
//    showSystemUi = false,
//    showBackground = true
//)
//@Composable
//fun SelectionCityScreenPreview() = SelectionCityScreen()