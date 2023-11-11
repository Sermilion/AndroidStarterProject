package io.readian.uniapp.feature.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.readian.android.R
import io.readian.uniapp.feature.adlist.AdListContract

@Composable
fun AdItem(
  item: AdListContract.Ad,
  onClick: () -> Unit,
) {
  Surface(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp),
    shape = MaterialTheme.shapes.small,
    onClick = onClick,
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f))
        .padding(16.dp)
    ) {
      Text(
        text = item.name,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
          .padding(bottom = 8.dp),
      )

      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(200.dp)
      ) {
        Surface(
          shape = MaterialTheme.shapes.extraSmall,
        ) {
          Image(
            painter = painterResource(id = R.drawable.image_welcome),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth,
          )

          Box(
            modifier = Modifier
              .fillMaxSize()
              .background(
                brush = Brush.verticalGradient(
                  colors = listOf(
                    Color.Transparent,
                    Color.Black.copy(alpha = 0.5f),
                  )
                )
              )
          )
        }


        Text(
          text = item.price,
          style = MaterialTheme.typography.bodyLarge,
          modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(start = 8.dp, bottom = 4.dp),
          maxLines = 3,
        )
      }

      Text(
        text = item.description,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(top = 8.dp),
      )
    }
  }
}