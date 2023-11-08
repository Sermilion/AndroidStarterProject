package io.readian.android.onboarding.profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import io.readian.uniapp.designsystem.icon.ReadianIcons
import io.readian.uniapp.designsystem.icon.UserPlaceholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
  Scaffold(
    modifier = Modifier.systemBarsPadding(),
    topBar = {
      TopAppBar(
        title = {

        },
        navigationIcon = {
          IconButton(
            onClick = {},
          ) {
            Icon(
              imageVector = Icons.Outlined.ArrowBack,
              contentDescription = null,
            )
          }
        },
      )
    }
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.surface)
        .padding(paddingValues),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {

      Image(
        imageVector = ReadianIcons.UserPlaceholder,
        contentDescription = null,
        modifier = Modifier
          .size(160.dp)
          .padding(top = 36.dp),
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
      )

      // TODO: text for name

      Divider(modifier = Modifier.padding(start = 16.dp))
      ProfileElement(
        name = "Email",
        onClick = {

        },
      )
      ProfileElement(
        name = "Change Password",
        onClick = {

        },
      )
      ProfileElement(
        name = "Logout",
        onClick = {

        },
      )
    }
  }
}

@Composable
private fun ProfileElement(
  name: String,
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
) {
  Surface(
    onClick = onClick,
    modifier = Modifier
      .fillMaxWidth()
      .height(50.dp)
      .padding(horizontal = 18.dp)
      .then(modifier),
  ) {
    Column(modifier = Modifier.fillMaxSize()) {
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
          .fillMaxWidth()
          .height(48.dp),
      ) {
        Text(
          text = name,
          style = MaterialTheme.typography.bodySmall,
        )

        Icon(
          imageVector = Icons.Outlined.ArrowForwardIos,
          contentDescription = null,
          modifier = Modifier.size(width = 12.dp, height = 24.dp),
        )
      }

      Divider()
    }
  }
}