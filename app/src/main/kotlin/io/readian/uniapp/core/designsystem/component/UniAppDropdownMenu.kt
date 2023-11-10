package io.readian.uniapp.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UniAppDropdownMenu(
  items: List<String>,
) {
  var expanded by remember { mutableStateOf(false) }
  var selectedIndex by remember { mutableStateOf(0) }
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(48.dp)
      .padding(top = 8.dp)
      .padding(horizontal = 32.dp)
      .wrapContentSize(Alignment.Center)
  ) {
    Text(
      items[selectedIndex],
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 4.dp)
        .clickable(onClick = { expanded = true })
    )
    androidx.compose.material3.DropdownMenu(
      expanded = expanded,
      onDismissRequest = { expanded = false },
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 32.dp)
    ) {
      items.forEachIndexed { index, item ->
        DropdownMenuItem(
          text = { Text(text = item) },
          onClick = {
            selectedIndex = index
            expanded = false
          })
      }
    }
  }
}
