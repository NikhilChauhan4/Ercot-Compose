package com.example.ercotenergysaver.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ercotenergysaver.R
import com.example.ercotenergysaver.compose.screens.home.tabs.TabItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun HomeScreen() {
  val pagerState = rememberPagerState()
  val tabs = listOf(
    TabItem.CurrentStatus,
    TabItem.Forecast,
  )
  Column(
    modifier = Modifier
      .fillMaxSize()
      .wrapContentSize(Alignment.Center)
  ) {
    Tabs(tabs = tabs, pagerState = pagerState)
    TabsContent(tabs = tabs, pagerState = pagerState)
  }
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
  val scope = rememberCoroutineScope()
  // OR ScrollableTabRow()
  TabRow(
    selectedTabIndex = pagerState.currentPage,
    backgroundColor = colorResource(id = R.color.purple_200),
    contentColor = Color.White,
    indicator = { tabPositions ->
      TabRowDefaults.Indicator(
        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
      )
    }) {
    tabs.forEachIndexed { index, tab ->
      // OR Tab()
      Tab(
        text = { Text(tab.title) },
        selected = pagerState.currentPage == index,
        onClick = {
          scope.launch {
            pagerState.animateScrollToPage(index)
          }
        },
      )
    }
  }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun TabsPreview() {
  val tabs = listOf(
    TabItem.CurrentStatus,
    TabItem.Forecast,
  )
  val pagerState = rememberPagerState()
  Tabs(tabs = tabs, pagerState = pagerState)
}

@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
  HorizontalPager(state = pagerState, count = tabs.size) { page ->
    tabs[page].screen()
  }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun TabsContentPreview() {
  val tabs = listOf(
    TabItem.CurrentStatus,
    TabItem.Forecast,
  )
  val pagerState = rememberPagerState()
  TabsContent(tabs = tabs, pagerState = pagerState)
}
