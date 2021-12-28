package com.example.ercotenergysaver.compose.bottomnavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
  val items = listOf(
      NavigationItem.Home,
      NavigationItem.WholeSalePrices,
      NavigationItem.News,
      NavigationItem.About,
      NavigationItem.QuickLinks
  )
  BottomNavigation(
      contentColor = Color.White
  ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    items.forEach { item ->
      BottomNavigationItem(
          selected = currentRoute == item.route,
          onClick = {
            navController.navigate(item.route) {
              // Pop up to the start destination of the graph to
              // avoid building up a large stack of destinations
              // on the back stack as users select items
              navController.graph.startDestinationRoute?.let { route ->
                popUpTo(route) {
                  saveState = true
                }
              }
              // Avoid multiple copies of the same destination when
              // reselecting the same item
              launchSingleTop = true
              // Restore state when reselecting a previously selected item
              restoreState = true
            }
          },
          icon = {
            Icon(
                item.icon, contentDescription = item.title
            )
          },
          selectedContentColor = Color.White,
          unselectedContentColor = Color.White.copy(0.5f)
      )
    }

  }
}
