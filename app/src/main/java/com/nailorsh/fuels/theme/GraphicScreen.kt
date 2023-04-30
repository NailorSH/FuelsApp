//package com.nailorsh.fuels.theme
//
//import android.content.Context
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.toArgb
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import java.time.LocalDate
//import com.github.mikephil.charting.*
//import com.github.mikephil.charting.charts.*
//import com.github.mikephil.charting.components.*
//import com.github.mikephil.charting.data.BarData
//import com.github.mikephil.charting.data.BarDataSet
//import com.github.mikephil.charting.data.BarEntry
//import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
//import com.github.mikephil.charting.interfaces.datasets.*
//
//@Composable
//fun BarChartView(
//    fuel: List<String>,
//    oldPrices: List<Double>,
//    newPrices: List<Double>,
//    oldDate: LocalDate,
//    newDate: LocalDate
//) {
//    MaterialTheme {
//        AndroidView(
//            modifier = Modifier.fillMaxSize().padding(20.dp, 20.dp),
//            factory = { context ->
//                val barChart = BarChart(context)
//
//                // Конфигурируем BarChart
//                barChart.description.isEnabled = false // Отключаем описание графика
//                barChart.setPinchZoom(false) // Отключаем приближение жестами
//
//                val yAxis = barChart.axisLeft // Получаем ось Y
//                yAxis.axisMinimum = 0f
//                yAxis.axisMaximum = 100f
//                yAxis.setDrawGridLines(false) // Отключаем сетку на оси Y
//
//                barChart.axisRight.isEnabled = false // Отключаем правую ось Y
//                barChart.legend.isEnabled = true // Отключаем легенду
//
//                // Заполняем данными
//                val entries1 = mutableListOf<BarEntry>()
//                val entries2 = mutableListOf<BarEntry>()
//                for (i: Int in fuel.indices) {
//                    entries1.add(BarEntry(i.toFloat() - 0.2f, oldPrices[i].toFloat()))
//                    entries2.add(BarEntry(i.toFloat() + 0.2f, newPrices[i].toFloat()))
//                }
//                val dataSet1 = BarDataSet(entries1, "Цена $oldDate")
//                val dataSet2 = BarDataSet(entries2, "Цена $newDate")
//
//                val dataSet = BarData(dataSet1, dataSet2)
//                dataSet1.valueTextSize = 14f
//                dataSet1.color = Red.toArgb()
//                dataSet2.valueTextSize = 14f
//                dataSet2.color = DarkRed.toArgb()
//
//                barChart.data = dataSet
//                barChart.data.barWidth = 0.25f
//
//                val xAxis = barChart.xAxis // Получаем ось X
//                xAxis.labelCount = fuel.size
//                xAxis.textSize = 24f
//                xAxis.position = XAxis.XAxisPosition.BOTTOM // Позиционируем её внизу
//                xAxis.setDrawGridLines(false) // Отключаем сетку на оси X
//                xAxis.valueFormatter = IndexAxisValueFormatter(fuel) // Устанавливаем названия топлив
//                val legend = barChart.legend
//                legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP // Позиция легенды
//                legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT // Позиция легенды
//                legend.setDrawInside(false) // Включаем отображение легенды внутри графика
//                legend.textSize = 16f // Размер текста в легенде
//                legend.textColor = Color.Black.toArgb() // Цвет текста в легенде
//                legend.form = Legend.LegendForm.SQUARE // Форма маркера в легенде
//                legend.formSize = 12f
//                legend.formToTextSpace = 8f
//                legend.yEntrySpace = 12f
//
//                barChart
//            }
//        )
//    }
//}
//
//@Composable
//fun BarChartView(context: Context) {
//    MaterialTheme {
//        AndroidView(
//            modifier = Modifier.fillMaxSize(),
//            factory = {
//                val barChart = BarChart(context)
//                // Конфигурируйте barChart здесь, вам также нужно заполнить его данными для отображения
//                barChart
//            }
//        )
//    }
//}