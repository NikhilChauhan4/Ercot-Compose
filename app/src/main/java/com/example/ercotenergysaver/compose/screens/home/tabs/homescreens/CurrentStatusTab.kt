package com.example.ercotenergysaver.compose.screens.home.tabs.homescreens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ercotenergysaver.compose.data.PlaceholderData
import com.example.ercotenergysaver.ui.theme.Shapes

@Composable
fun CurrentStatusTab() {
  Column(
      modifier = Modifier
          .fillMaxSize()
          .wrapContentSize(Alignment.Center)
  ) {
    PreviewLazyRow()
  }
}

@Preview
@Composable
fun PreviewLazyRow() {
  val dataItem = PlaceholderData(
      "What is an energy emergency?",
      "When an electric supply and demand can't be balanced" +
          "with normal procedures,ERCOT will declare and energy emergency" +
          ",which allows the grid operator to use resources only during tight conditions.",
      "View all definitions"
  )
  val placeholderDataList = arrayListOf<PlaceholderData>(dataItem)

  CurrentStatusList(statusItems = placeholderDataList)
}

@Composable
fun CurrentStatusList(statusItems: List<PlaceholderData>) {
  LazyColumn(
      contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
      verticalArrangement = Arrangement.spacedBy(
          16.dp
      )
  ) {
    items(statusItems) { item ->
      StatusColumn(item)
    }
  }
}

@Composable
fun StatusColumn(data: PlaceholderData) {

  Column(
      modifier = Modifier.border(
          color = Color.Gray, width = 1.dp,
          shape = RectangleShape
      ),
      verticalArrangement = Arrangement.spacedBy(
          20.dp
      )
  ) {
    Text(
        text = data.head,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
    )
    Text(
        text = data.body,
        style = MaterialTheme.typography.body2
    )
    Text(
        text = data.bodyText,
        style = TextStyle(color = Color.Blue),
        modifier = Modifier.align(Alignment.End),
    )
  }
}

@Preview(showBackground = true)
@Composable
fun CurrentStatusTabPreview() {
  CurrentStatusTab()
}
