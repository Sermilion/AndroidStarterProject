package io.readian.android.onboarding.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.readian.android.feature.onboarding.R
import io.readian.uniapp.designsystem.component.CredentialTextField
import io.readian.uniapp.designsystem.component.HeaderText
import io.readian.uniapp.designsystem.component.PrimaryButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
  Scaffold(
    modifier = Modifier.systemBarsPadding(),
    topBar = {
      TopAppBar(
        title = {},
        navigationIcon = {
          IconButton(
            onClick = {}
            ,
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
      var email by remember { mutableStateOf("") }
      var password by remember { mutableStateOf("") }

      HeaderText(
        text = stringResource(id = R.string.label_log_in),
        modifier = Modifier.padding(top = 32.dp),
      )

      CredentialTextField(
        value = email,
        label = "Enter email",
        onValueChanged = {
          email = it
        },
        modifier = Modifier.padding(top = 40.dp)
      )

      CredentialTextField(
        value = password,
        label = "Enter password",
        onValueChanged = {
          password = it
        },
        modifier = Modifier.padding(top = 8.dp),
      )

      TextButton(onClick = { /*TODO*/ }) {
        Text(
          text = "Forgot password?",
          style = MaterialTheme.typography.bodyMedium,
        )
      }


      PrimaryButton(
        text = stringResource(id = R.string.label_log_in),
        onClick = {

        },
      )

      Image(
        painter = painterResource(id = R.drawable.ic_police),
        contentDescription = null,
        modifier = Modifier
          .size(width = 300.dp, height = 50.dp)
          .padding(top = 30.dp),
      )
    }
  }
}
