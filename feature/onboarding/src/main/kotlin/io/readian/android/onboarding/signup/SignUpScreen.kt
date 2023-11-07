package io.readian.android.onboarding.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import io.readian.uniapp.designsystem.component.HeaderText
import io.readian.uniapp.designsystem.component.PrimaryButton

@Composable
fun LoginScreen() {
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
        text = stringResource(id = R.string.label_sign_up),
        modifier = Modifier.padding(top = 32.dp)
      )

      Text(
        text = "Username",
        modifier = Modifier.padding(top = 40.dp)
      )
      var text by remember { mutableStateOf("") }

      TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        modifier = Modifier.padding(all = 10.dp),
        label = { Text("Enter username") }
      )
      Text(
        text = "Email",
        modifier = Modifier.padding(top = 10.dp)
      )
      TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        modifier = Modifier.padding(all = 10.dp),
        label = { Text("Enter e-mail") }
      )
      TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        modifier = Modifier.padding(all = 10.dp),
        label = { Text("Password") }
      )

      PrimaryButton(
        text = stringResource(id = R.string.label_sign_up),
        onClick = {

        }
      )

      Row {
        Image(
          painter = painterResource(id = R.drawable.ic_google),
          contentDescription = null,
          modifier = Modifier
              .size(width = 50.dp, height = 50.dp)
              .padding(top = 20.dp),
        )

        Image(
          painter = painterResource(id = R.drawable.ic_facebook),
          contentDescription = null,
          modifier = Modifier
              .size(width = 50.dp, height = 50.dp)
              .padding(top = 20.dp),
        )
      }
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
