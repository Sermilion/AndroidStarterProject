package io.readian.android.onboarding.welcome.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.readian.android.feature.onboarding.R
import io.readian.uniapp.designsystem.component.HeaderText
import io.readian.uniapp.designsystem.component.PrimaryButton
import io.readian.uniapp.designsystem.theme.surface

@Composable
fun WelcomeScreen() {

  Scaffold(
    modifier = Modifier.fillMaxSize(),
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        // TODO: change to ReadianTheme
        .background(color = surface)
        .padding(paddingValues),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      HeaderText(
        text = stringResource(id = R.string.label_app_name),
        modifier = Modifier.padding(top = 32.dp)
      )

      Image(
        painter = painterResource(id = R.drawable.image_welcome),
        contentDescription = null,
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 60.dp),
        contentScale = ContentScale.FillWidth,
      )

      PrimaryButton(
        text = stringResource(id = R.string.label_login),
        onClick = {

        },
        modifier = Modifier.padding(top = 32.dp)
      )

      PrimaryButton(
        text = stringResource(id = R.string.label_register),
        onClick = {

        }
      )
    }
  }
}
