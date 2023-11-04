package io.readian.android.onboarding.welcome.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreen(
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier,
    onSkipClicked: () -> Unit,
) {

//    onLoginClicked()
//    onSignUpClicked()
//    onSkipClicked()
//    Scaffold(
//        modifier = Modifier.fillMaxSize().then(modifier),
//    ) {
//        Column(
//            modifier = Modifier.padding(it),
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically,
//            ) {
//                Icon(
//                    imageVector = ReadianIcons.ReadianLetter,
//                    contentDescription = stringResource(id = R.string.desc_readina_icon_letter),
//                    tint = MaterialTheme.colorScheme.primary,
//                )
//
//                Icon(
//                    imageVector = ReadianIcons.ReadianText,
//                    contentDescription = stringResource(id = R.string.desc_readina_icon_text),
//                    modifier = Modifier.padding(start = 8.dp),
//                    tint = MaterialTheme.colorScheme.primary,
//                )
//            }
//        }
//    }
}
