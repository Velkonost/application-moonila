package features.profile.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.profile.presentation.ProfileViewModel
import features.profile.presentation.contract.ProfileNavigation
import features.profile.presentation.screen.components.AnonymousBlock
import features.profile.presentation.screen.components.Header
import features.profile.presentation.screen.components.NotificationsBlock
import features.profile.presentation.screen.components.UserDataBlock
import features.profile.presentation.screen.components.settings.SettingsSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    val settingsSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(
                colorResource(id = com.moonila.core.compose.R.color.general_bg),
            )
            .padding(bottom = 100.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            onBackClick = {
                viewModel.dispatch(ProfileNavigation.NavigateBack)
            },
            onSettingsClick = {
                scope.launch {
                    settingsSheetState.show()
                }
            }
        )

        AnonymousBlock {

        }

        UserDataBlock(
            userName = "Maksim Mironov",
            birthPlace = "Born May 11, 1994 at 10:13 am,\n" +
                    "Novosibirsk, Russia",
            moonText = "Moon in Taurus",
            onEditProfileClick = {

            }
        )

        NotificationsBlock()
    }

    SettingsSheet(modalSheetState = settingsSheetState)
}