package com.nailorsh.fuels.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nailorsh.fuels.data.retrofit.Card
import com.nailorsh.fuels.data.retrofit.City
import com.nailorsh.fuels.data.retrofit.CityApi
import kotlinx.coroutines.runBlocking


fun getDateNotT(date: String): List<Int> {
    return date.split("-").map { it.toInt() }
}

fun compareDate(a: List<Int>, b: List<Int>): Boolean {
    for (i in 0..2) {
        if (a[i] > b[i])
            return true
        if (a[i] < b[i])
            return false
    }
    return true
}

//fun getDates(
//    cityApi: CityApi,
//    date1: String,
//    date2: String,
//    name: String
//): Map<String, List<Double>> {
//    val cities = mutableListOf<String>()
//    val allCities = runBlocking { cityApi.getAllCities() }
//    val prices = mutableMapOf<String, List<Double>>()
//    val l = getDateNotT(date1)
//    val r = getDateNotT(date2)
//    var tCity: City = City(0, "", emptyMap())
//    for (city in allCities) {
//        if (city.name == name) {
//            tCity = city
//            break
//        }
//    }
//    for ((key, value) in tCity.prices) {
//        if (compareDate(getDateNotT(key), l) && compareDate(r, getDateNotT(key))) {
//            prices[key] = value
//        }
//    }
//    return prices
//}


fun getCards(
    cityApi: CityApi,
    date1: String,
    date2: String,
    name: String
): List<Card> {
    val cities = mutableListOf<String>()
    val allCities = runBlocking { cityApi.getAllCities() }
    val cards = mutableListOf<Card>()
    val l = getDateNotT(date1)
    val r = getDateNotT(date2)
    var tCity = City(0, "", emptyMap())
    for (city in allCities) {
        if (city.name == name) {
            tCity = city
            break
        }
    }

    for ((key, value) in tCity.prices) {
        if (compareDate(getDateNotT(key), l) && compareDate(r, getDateNotT(key))) {
            cards.add(Card(key, value))
        }
    }

    return cards
}


fun getCost(cityApi: CityApi, name: String, date: String): List<Double> {
    val cities = mutableListOf<String>()
    val allCities = runBlocking { cityApi.getAllCities() }
    var prices = emptyList<Double>()
    for (city in allCities) {
        if (city.name == name) {
            if (city.prices.containsKey(date))
                prices = city.prices[date]!!
            break
        }
    }
    return prices
}

@Composable
fun SelectionDataScreen(
    onCardClicked: (String) -> Unit = {},
    cityApi: CityApi,
    selectedCity: String
) {
    Column(modifier = Modifier.fillMaxSize()) {
        ShowStartAndEndData()
        ListOfDataCards(cityApi, selectedCity)
    }
}


@Composable
fun ShowStartAndEndData() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        SelectionData(
            dataType = "start",
            modifier = Modifier
                .weight(1f)
        )
        SelectionData(
            dataType = "end",
            modifier = Modifier
                .weight(1f)
        )
    }
}


@Composable
fun SelectionData(dataType: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
        } ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = dataType,
                modifier = Modifier.size(40.dp)
            )
        }

        Text(text = dataType)
    }
}

@Composable
fun ListOfDataCards(
    cityApi: CityApi,
    selectedCity: String
) {
    val startData = "2023-03-01"
    val endData = "2023-04-30"


    val cardsData: List<Card> = getCards(cityApi, startData, endData, selectedCity)

    //    val cardsData = listOf(
//        Card("2023-05-01", listOf(10.5, 20.3, 30.1)),
//        Card("2023-05-02", listOf(11.2, 19.8, 28.5)),
//        Card("2023-05-03", listOf(9.7, 21.1, 31.4))
//    )

    val fuels = listOf("ДТ", "92", "95")

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(cardsData) { card ->
            DataCard(card.date, fuels, card.prices)
        }
    }
}

@Composable
fun DataCard(data: String, fuels: List<String>, prices: List<Double>) {
//    Card(
//        elevation = 10.dp,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//    ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .padding(40.dp)
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .clickable {

            }
    )

    {
        Text(
            text = data,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 5.dp, top = 5.dp)
        )
        Divider(
            thickness = 1.dp,
            modifier = Modifier
                .padding(15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            FuelsList(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                fuels = fuels
            )
            PricesList(
                modifier = Modifier
                    .weight(1f),
                prices = prices
            )
        }
    }
//    }
}

@Composable
fun FuelsList(
    fuels: List<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        items(fuels) { item ->
            Text(text = item)
        }
    }
}

@Composable
fun PricesList(prices: List<Double>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        items(prices) { item ->
            Text(text = "$item")
        }
    }
}





//@Preview(
//    name = "SelectionDataScreen",
//    showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun SelectionDataScreen() = DataCard(
//    "15 april",
//    listOf("ДТ", "92", "95"),
//    listOf(5, 10, 15)
//)





@Preview(
    name = "SelectionDataScreen",
    showSystemUi = true,
    showBackground = true
)
@Composable
fun ShowStartAndEndDataPre() = ShowStartAndEndData()