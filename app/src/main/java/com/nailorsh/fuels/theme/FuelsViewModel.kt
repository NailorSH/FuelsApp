package com.nailorsh.fuels.theme

import androidx.lifecycle.ViewModel
import com.nailorsh.fuels.data.FuelsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * [OrderViewModel] holds information about a cupcake order in terms of quantity, flavor, and
 * pickup date. It also knows how to calculate the total price based on these order details.
 */
class FuelsViewModel : ViewModel() {

    /**
     * Cupcake state for this order
     */
    private val _uiState = MutableStateFlow(FuelsUiState(/*pickupOptions = pickupOptions()*/))
    val uiState: StateFlow<FuelsUiState> = _uiState.asStateFlow()

    /**
     * Set the quantity [numberCupcakes] of cupcakes for this order's state and update the price
     */
    fun setCity(selectedСity: String) {
        _uiState.update { currentState ->
            currentState.copy(city = selectedСity)
        }
    }

    fun setCitiesList(selectedCitiesList: List<String>) {
        _uiState.update { currentState ->
            currentState.copy(cities = selectedCitiesList)
        }
    }

    fun setStartDate(pickupDate: String) {
        _uiState.update { currentState ->
            currentState.copy(
                startDate = pickupDate
            )
        }
    }

    fun setEndDate(pickupDate: String) {
        _uiState.update { currentState ->
            currentState.copy(
                endDate = pickupDate
            )
        }
    }

    /**
     * Reset the order state
     */
    fun resetOrder() {
        _uiState.value = FuelsUiState(/*pickupOptions = pickupOptions()*/)
    }

    /**
     * Returns the calculated price based on the order details.
     */
//    private fun calculatePrice(
//        quantity: Int = _uiState.value.quantity,
//        pickupDate: String = _uiState.value.date
//    ): String {
//        var calculatedPrice = quantity * PRICE_PER_CUPCAKE
//        // If the user selected the first option (today) for pickup, add the surcharge
//        if (pickupOptions()[0] == pickupDate) {
//            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
//        }
//        val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
//        return formattedPrice
//    }

    /**
     * Returns a list of date options starting with the current date and the following 3 dates.
     */
//    private fun pickupOptions(): List<String> {
//        val dateOptions = mutableListOf<String>()
//        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
//        val calendar = Calendar.getInstance()
//        // add current date and the following 3 dates.
//        repeat(4) {
//            dateOptions.add(formatter.format(calendar.time))
//            calendar.add(Calendar.DATE, 1)
//        }
//        return dateOptions
//    }
}