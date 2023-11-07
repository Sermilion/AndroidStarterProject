package io.readian.android.onboarding.PasswordRecovery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
                text = stringResource(id = R.string.label_password_recovery),
                modifier = Modifier.padding(top = 32.dp)
            )

            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                modifier = Modifier.padding(all = 10.dp),
                label = { Text("Email Address") }
            )
        }
        PrimaryButton(
            text = stringResource(id = R.string.label_continue),
            onClick = {

            }
        )
    }
}