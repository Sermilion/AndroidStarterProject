package io.readian.android.onboarding.password_recovery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.readian.android.feature.onboarding.R
import io.readian.uniapp.designsystem.component.CredentialTextField
import io.readian.uniapp.designsystem.component.HeaderText
import io.readian.uniapp.designsystem.component.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordRecoveryScreen(
  onBackClick: () -> Unit,
) {
  Scaffold(
    modifier = Modifier.systemBarsPadding(),
    topBar = {
      TopAppBar(
        title = {

        },
        navigationIcon = {
          IconButton(
            onClick = onBackClick,
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
        .padding(paddingValues),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      HeaderText(
        text = stringResource(id = R.string.label_password_recovery),
        modifier = Modifier.padding(top = 32.dp)
      )

      var email by remember { mutableStateOf("") }

      CredentialTextField(
        value = email,
        label = "Enter email",
        onValueChanged = {
          email = it
        },
        modifier = Modifier.padding(top = 8.dp),
      )

      PrimaryButton(
        text = stringResource(id = R.string.label_continue),
        onClick = {

        },
        modifier = Modifier.padding(top = 22.dp)
      )
    }
  }
}