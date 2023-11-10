package io.readian.uniapp.feature.advertisers.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.readian.uniapp.feature.advertisers.AdvertisersViewModel

@Composable
fun AdvertisersScreen(
  viewModel: AdvertisersViewModel = hiltViewModel()
) {
  val state by viewModel.state.collectAsStateWithLifecycle()


}