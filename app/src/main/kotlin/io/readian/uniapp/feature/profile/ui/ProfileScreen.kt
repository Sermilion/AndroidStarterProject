package io.readian.uniapp.feature.profile.ui

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.readian.android.R
import io.readian.uniapp.core.database.model.UserType
import io.readian.uniapp.core.designsystem.icon.ReadianIcons
import io.readian.uniapp.core.designsystem.icon.UserPlaceholder
import io.readian.uniapp.feature.common.composable.AdItem
import io.readian.uniapp.feature.profile.ProfileContract
import io.readian.uniapp.feature.profile.ProfileViewModel
import java.util.UUID

@Composable
fun ProfileScreen(
  viewModel: ProfileViewModel = hiltViewModel(),
  onCreateAd: () -> Unit,
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  when (val state = uiState) {
    ProfileContract.UiState.Error -> {
      // error
    }

    ProfileContract.UiState.Loading -> CircularProgressIndicator()
    is ProfileContract.UiState.Profile -> ProfileScreen(
      state = state,
      onLogoutClick = {
        viewModel.logout()
      },
      onRemoveAd = {
        viewModel.removeAd(it)
      },
      onCreateAd = onCreateAd,
    )
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
  state: ProfileContract.UiState.Profile,
  onLogoutClick: () -> Unit,
  onCreateAd: () -> Unit,
  onRemoveAd: (UUID) -> Unit,
) {
  Scaffold(
    modifier = Modifier.systemBarsPadding(),
    topBar = {
      CenterAlignedTopAppBar(
        title = {
          Text(
            text = stringResource(id = R.string.label_profile),
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
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.surface)
        .padding(paddingValues),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      val listState = rememberLazyListState()

      LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = listState,
        contentPadding = paddingValues,
      ) {

        item {
          Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {
            Image(
              imageVector = ReadianIcons.UserPlaceholder,
              contentDescription = null,
              modifier = Modifier
                .size(140.dp),
              colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            )

            Text(
              text = state.username,
              modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
              text = state.type.name,
              modifier = Modifier.padding(vertical = 8.dp)
            )
          }
        }

        item {
          Divider(modifier = Modifier.padding(start = 16.dp))
        }

        item {
          ProfileElement(
            name = "Email",
            onClick = {

            },
          )
        }

        item {
          ProfileElement(
            name = "Change Password",
            onClick = {

            },
          )
        }

        item {
          ProfileElement(
            name = "Logout",
            onClick = onLogoutClick,
          )
        }

        if (state.type == UserType.Advertiser) {
          item {
            TextButton(onClick = onCreateAd) {
              Text(
                text = "Create Ad",
                style = MaterialTheme.typography.bodyMedium,
              )
            }
          }
        }

        val items = state.ads

        items(count = items.size) { index ->
          AdItem(
            item = items[index],
            onClick = {},
            onRemove = {
              onRemoveAd(items[index].id)
            },
          )
        }
      }
      // show created ads
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