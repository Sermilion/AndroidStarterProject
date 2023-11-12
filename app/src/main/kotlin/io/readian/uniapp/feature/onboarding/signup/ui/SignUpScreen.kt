package io.readian.uniapp.feature.onboarding.signup.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.readian.android.R
import io.readian.uniapp.core.database.model.UserType
import io.readian.uniapp.core.designsystem.component.UniAppTextField
import io.readian.uniapp.core.designsystem.component.HeaderText
import io.readian.uniapp.core.designsystem.component.PrimaryButton
import io.readian.uniapp.core.designsystem.component.UniAppDropdownMenu
import io.readian.uniapp.feature.onboarding.signup.SignUpViewModel


@Composable
fun SignUpScreen(
  viewModel: SignUpViewModel = hiltViewModel(),
  onBackClick: () -> Unit,
  onLoginSuccess: () -> Unit,
) {
  val state by viewModel.uiState.collectAsStateWithLifecycle()

  SignUpScreen(
    typeList = state,
    onBackClick = onBackClick,
    onSignUpClick = { username, email, password, type ->
      viewModel.signUp(
        username = username,
        email = email,
        password = password,
        type = type,
      )
      onLoginSuccess()
    }
  )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
  typeList: List<String>,
  onBackClick: () -> Unit,
  onSignUpClick: (
    username: String,
    email: String,
    password: String,
    type: UserType,
  ) -> Unit,
) {
  Scaffold(
    modifier = Modifier.systemBarsPadding(),
    topBar = {
      TopAppBar(
        title = {},
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
        .background(color = MaterialTheme.colorScheme.surface)
        .padding(paddingValues),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {

      var username by remember { mutableStateOf("") }
      var email by remember { mutableStateOf("") }
      var password by remember { mutableStateOf("") }
      var userType by remember { mutableStateOf(UserType.Advertiser) }

      HeaderText(
        text = stringResource(id = R.string.label_sign_up),
        modifier = Modifier.padding(top = 32.dp)
      )

      UniAppTextField(
        value = username,
        label = "Enter username",
        onValueChanged = {
          username = it
        },
        modifier = Modifier.padding(top = 10.dp)
      )

      UniAppTextField(
        value = email,
        label = "Enter email",
        onValueChanged = {
          email = it
        },
        modifier = Modifier.padding(top = 8.dp),
      )

      UniAppTextField(
        value = password,
        label = "Enter password",
        onValueChanged = {
          password = it
        },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.padding(top = 8.dp),
      )

      UniAppDropdownMenu(
        items = typeList,
        onItemSelected = {
          userType = UserType.valueOf(it)
        },
      )

      PrimaryButton(
        text = stringResource(id = R.string.label_sign_up),
        onClick = {
          onSignUpClick(
            username,
            email,
            password,
            userType,
          )
        },
        modifier = Modifier.padding(top = 12.dp),
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



