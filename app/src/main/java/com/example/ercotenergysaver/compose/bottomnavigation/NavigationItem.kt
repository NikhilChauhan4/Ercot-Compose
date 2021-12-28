package com.example.ercotenergysaver.compose.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
  var route: String,
  var icon: ImageVector,
  var title: String
) {
  object Home : NavigationItem("Home", Icons.Filled.Home, "Home")
  object WholeSalePrices : NavigationItem("WholesalePrices", Icons.Filled.Search, "WholeSalePrices")
  object News : NavigationItem("News", Icons.Filled.Settings, "News")
  object About : NavigationItem("About", Icons.Filled.AccountCircle, "About")
  object QuickLinks : NavigationItem("QuickLinks", Icons.Filled.Person, "QuickLinks")
}