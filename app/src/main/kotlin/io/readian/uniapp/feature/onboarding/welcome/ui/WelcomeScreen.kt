package io.readian.uniapp.feature.onboarding.welcome.ui

import androidx.compose.foundation.Image
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
import io.readian.android.R
import io.readian.uniapp.core.designsystem.component.HeaderText

@Composable
fun WelcomeScreen(
  onLoginClick: () -> Unit,
  onRegisterClick: () -> Unit,
) {

  Scaffold(
    modifier = Modifier.fillMaxSize(),
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxSize()
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

      io.readian.uniapp.core.designsystem.component.PrimaryButton(
        text = stringResource(id = R.string.label_login),
        onClick = onLoginClick,
        modifier = Modifier.padding(top = 32.dp)
      )

      io.readian.uniapp.core.designsystem.component.PrimaryButton(
        text = stringResource(id = R.string.label_register),
        onClick = onRegisterClick,
      )
    }
  }
}
