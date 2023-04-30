package com.nailorsh.fuels

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nailorsh.fuels.data.retrofit.CityApi
import com.nailorsh.fuels.theme.FuelsViewModel
import com.nailorsh.fuels.theme.GraphicScreen
import com.nailorsh.fuels.theme.ListOfDataCards
import com.nailorsh.fuels.theme.SelectionCityScreen
import com.nailorsh.fuels.theme.SelectionDataScreen
import com.nailorsh.fuels.theme.StartSplashScreen
import com.nailorsh.fuels.ui.theme.BrandColor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.LocalDate

enum class FuelsScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    City(title = R.string.choose_city),
    Date(title = R.string.choose_date),
    Graphic(title = R.string.graphic)
}

@Composable
fun FuelsAppBar(
    currentFuelsScreen: FuelsScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentFuelsScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        backgroundColor = BrandColor,
        contentColor = Color.White
    )
}

@Composable
fun FuelsApp(
    modifier: Modifier = Modifier,
    viewModel: FuelsViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentFuelsScreen = FuelsScreen.valueOf(
        backStackEntry?.destination?.route ?: FuelsScreen.City.name
    )
    val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/nikvoen/server/")
        .addConverterFactory(MoshiConverterFactory.create()).build()
    val cityApi = retrofit.create(CityApi::class.java)

    Scaffold(
        topBar = {
            if (currentFuelsScreen == FuelsScreen.Start) null else {
                FuelsAppBar(
                    currentFuelsScreen = currentFuelsScreen,
                    canNavigateBack = navController.previousBackStackEntry != null && currentFuelsScreen != FuelsScreen.City,
                    navigateUp = { navController.navigateUp() }
                )
            }
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = FuelsScreen.Start.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = FuelsScreen.Start.name) {
                StartSplashScreen(
                    onNextButtonClicked = {
                        navController.navigate(FuelsScreen.City.name)
                    }
                )
            }

            composable(route = FuelsScreen.City.name) {
                SelectionCityScreen(
                    cityApi = cityApi,
//                    citiesList = uiState.cities,
//                    onDownloadData = {
//                        it.let { citiesList ->
//                            viewModel.setCitiesList(citiesList)
//                        }
//                    },
                    onListItemClicked = {
                        viewModel.setCity(it)
                        navController.navigate(FuelsScreen.Date.name)
                    }
                )
            }

            composable(route = FuelsScreen.Date.name) {
                SelectionDataScreen(
                    cityApi = cityApi,
                    selectedCity = uiState.city,
                    onListCardClicked = {
                        navController.navigate(FuelsScreen.Graphic.name)
                    }
                )

            }
            composable(route = FuelsScreen.Graphic.name) {
                val fuel = listOf("A-92", "A-95", "ДТ")
                val oldPrices = listOf(37.5, 40.1, 42.9)
                val newPrices = listOf(41.0, 43.8, 46.5)
                val oldDate = LocalDate.of(2020, 9, 1)
                val newDate = LocalDate.of(2020, 10, 1)
                GraphicScreen(
                    fuel = fuel,
                    oldPrices = oldPrices,
                    newPrices = newPrices,
                    oldDate = oldDate,
                    newDate = newDate
                )
            }
        }
    }
}