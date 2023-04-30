package com.nailorsh.fuels.theme

import android.sax.TextElementListener
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectionDataScreen(
    onCardClicked: (String) -> Unit = {}
) {

}

@Composable
fun ShowStartAndEndData() {

}

@Composable
fun DataCard(data: String, fuels: List<String>, prices: List<Int>) {
    val paddingModifier = Modifier.padding(10.dp)

    Card(
        elevation = 10.dp,
        contentColor = Color.Blue,
        modifier = paddingModifier
    ) {
        Column {
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
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                FuelsList(
                    modifier = Modifier
                        .weight(1f),
                    fuels = fuels
                )
                LazyColumn(
                    modifier = Modifier
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    items(fuels) { item ->
                        Text(text = item)
                    }
                }

            }
        }
    }
}

@Composable
fun FuelsList(fuels: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(fuels) { item ->
            Text(text = item)
        }
    }
}

@Preview(
    name = "SelectionDataScreen",
    showSystemUi = true,
    showBackground = true
)
@Composable
fun SelectionDataScreen() = DataCard(
    "15 april",
    listOf("ДТ", "92", "95"),
    listOf(5, 10, 15)
)