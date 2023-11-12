package io.readian.uniapp.feature.adlist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.readian.uniapp.core.database.model.UserType
import io.readian.uniapp.feature.adlist.AdListContract.UiState
import io.readian.uniapp.feature.adlist.AdListViewModel
import io.readian.uniapp.feature.common.composable.AdItem

@Composable
fun AdListScreen(
  viewModel: AdListViewModel = hiltViewModel()
) {
  val state by viewModel.state.collectAsStateWithLifecycle()

  AdListScreen(
    state = state,
    onClick = { name, userType ->
      if (userType == UserType.Company) {
        viewModel.onAdSelected(name)
      }
    }
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AdListScreen(
  state: UiState,
  modifier: Modifier = Modifier,
  onClick: (String, UserType) -> Unit,
) {
  Scaffold(
    modifier = Modifier
      .systemBarsPadding()
      .then(modifier),
    topBar = {
      CenterAlignedTopAppBar(
        title = {
          Text(
            text = "Ad List",
            style = MaterialTheme.typography.titleMedium,
          )
        },
        navigationIcon = {
          Icon(
            imageVector = Icons.Outlined.Home,
            contentDescription = null,
          )
        },
      )
    }
  ) { paddingValues ->

    when (state) {
      is UiState.Content -> {
        val listState = rememberLazyListState()
        LazyColumn(
          modifier = Modifier.fillMaxSize(),
          state = listState,
          contentPadding = paddingValues,
        ) {
          val items = state.ads

          items(count = items.size) { index ->
            AdItem(
              item = items[index],
              onClick = {
                onClick(items[index].name, state.userType)
              },
            )
          }
        }
      }
      is UiState.Error -> Text(text = "Error")

      UiState.Loading -> CircularProgressIndicator()
      UiState.Empty -> {
        Box(
          contentAlignment = Alignment.Center,
          modifier = Modifier.fillMaxSize(),
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {
            Icon(
              imageVector = Icons.Outlined.Info,
              contentDescription = null,
              modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
              text = "No ads to display at this time. Please come back later.",
              style = MaterialTheme.typography.bodyLarge,
              modifier = Modifier.padding(horizontal = 32.dp),
              textAlign = TextAlign.Center,
            )
          }
        }
      }
    }
  }
}
