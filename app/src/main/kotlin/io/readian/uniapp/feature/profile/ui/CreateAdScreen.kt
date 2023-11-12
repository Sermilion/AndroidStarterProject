package io.readian.uniapp.feature.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.readian.uniapp.core.designsystem.component.HeaderText
import io.readian.uniapp.core.designsystem.component.PrimaryButton
import io.readian.uniapp.core.designsystem.component.UniAppTextField
import io.readian.uniapp.feature.profile.CreateAdViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAdScreen(
  viewModel: CreateAdViewModel = hiltViewModel(),
  onClose: () -> Unit,
) {

  Scaffold(
    modifier = Modifier.systemBarsPadding(),
    topBar = {
      TopAppBar(
        title = {},
        navigationIcon = {
          IconButton(onClick = onClose) {
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

      var adName by remember { mutableStateOf("") }
      var description by remember { mutableStateOf("") }
      var price by remember { mutableStateOf("") }
      var category by remember { mutableStateOf("") }

      HeaderText(
        text = "New Ad",
        modifier = Modifier.padding(top = 32.dp)
      )

      UniAppTextField(
        value = adName,
        label = "Enter ad name",
        onValueChanged = {
          adName = it
        },
        modifier = Modifier.padding(top = 10.dp)
      )

      UniAppTextField(
        value = description,
        label = "Enter description",
        onValueChanged = {
          description = it
        },
        modifier = Modifier.padding(top = 8.dp),
      )

      UniAppTextField(
        value = price,
        label = "Enter price",
        onValueChanged = {
          if (it.toIntOrNull() != null) {
            price = it
          }
        },
        modifier = Modifier.padding(top = 8.dp),
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Number,
        )
      )

      UniAppTextField(
        value = category,
        label = "Enter category",
        onValueChanged = {
          category = it
        },
        modifier = Modifier.padding(top = 8.dp),
      )

      PrimaryButton(
        text = "Create",
        onClick = {
          viewModel.onCreateAd(
            adName = category,
            description = description,
            price = price.toInt(),
            category = category,
          )
          onClose()
        },
        modifier = Modifier.padding(top = 12.dp),
      )
    }
  }
}
