package com.example.ercotenergysaver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ercotenergysaver.compose.TopAppBarLayout
import com.example.ercotenergysaver.compose.bottomnavigation.BottomNavigationBar
import com.example.ercotenergysaver.compose.bottomnavigation.NavigationItem
import com.example.ercotenergysaver.compose.screens.AboutScreen
import com.example.ercotenergysaver.compose.screens.HomeScreen
import com.example.ercotenergysaver.compose.screens.NewsScreen
import com.example.ercotenergysaver.compose.screens.QuickLinksScreen
import com.example.ercotenergysaver.compose.screens.WholeSalePricesScreenScreen
import com.example.ercotenergysaver.ui.theme.ErcotEnergySaverTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
  @ExperimentalPagerApi
  @ExperimentalMaterialApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ErcotEnergySaverTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          DashboardScreen()
        }
      }
    }
  }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun DashboardScreen() {
  val navController = rememberNavController()
  Scaffold(
    topBar = { TopAppBarLayout() },
    bottomBar = { BottomNavigationBar(navController) }
  ) {
    Navigation(navController = navController)
  }
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController) {
  NavHost(navController, startDestination = NavigationItem.Home.route) {
    composable(NavigationItem.Home.route) {
      HomeScreen()
    }
    composable(NavigationItem.About.route) {
      AboutScreen()
    }
    composable(NavigationItem.QuickLinks.route) {
      QuickLinksScreen()
    }
    composable(NavigationItem.WholeSalePrices.route) {
      WholeSalePricesScreenScreen()
    }
    composable(NavigationItem.News.route) {
      NewsScreen()
    }
  }
}