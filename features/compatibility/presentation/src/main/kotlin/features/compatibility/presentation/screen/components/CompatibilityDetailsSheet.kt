package features.compatibility.presentation.screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.moonila.features.compatibility.presentation.R
import features.compatibility.presentation.model.CompatibilityItem
import features.compatibility.presentation.screen.components.details.DetailsHeader
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CompatibilityDetailsSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
    item: CompatibilityItem
) {
    val scope = rememberCoroutineScope()

    BackHandler {
        scope.launch {
            modalSheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = colorResource(id = R.color.main_bg),
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f),
            ) {
                DetailsHeader {
                    scope.launch {
                        modalSheetState.hide()
                    }
                }

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 100.dp)
                        .padding(horizontal = 16.dp)
                ) {

                }

            }
        }
    ) {}
}