/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nailorsh.fuels.data



/**
 * Data class that represents the current UI state in terms of [quantity], [flavor],
 * [dateOptions], selected pickup [date] and [price]
 */
data class FuelsUiState(

    val city: String = "",
    val price: String = "",
    val date: String = "",
    val startDate: String = "",
    val endDate: String = "",
    val cities: List<String> = listOf(),
    val fuels: List<String> = listOf("ДТ", "92", "95"),
    val prices: List<Double> = mutableListOf<Double>()
)
