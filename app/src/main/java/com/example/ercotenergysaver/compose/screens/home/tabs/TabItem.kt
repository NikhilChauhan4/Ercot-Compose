package com.example.ercotenergysaver.compose.screens.home.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ercotenergysaver.compose.screens.home.tabs.homescreens.CurrentStatusTab
import com.example.ercotenergysaver.compose.screens.home.tabs.homescreens.ForecastTab

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: ImageVector, var title: String, var screen: ComposableFun) {
  object CurrentStatus : TabItem(Icons.Filled.Home, "Current Status", { CurrentStatusTab() })
  object Forecast : TabItem(Icons.Filled.Home, "Forecast", { ForecastTab() })
}