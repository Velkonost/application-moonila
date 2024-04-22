package features.wisdom.presentation.screen

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moonila.features.wisdom.presentation.R
import features.wisdom.presentation.WisdomViewModel
import features.wisdom.presentation.contract.WisdomAction
import features.wisdom.presentation.screen.components.BlockTitle
import features.wisdom.presentation.screen.components.CategoriesBlock
import features.wisdom.presentation.screen.components.Header

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WisdomScreen(
    modifier: Modifier = Modifier,
    viewModel: WisdomViewModel
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()
    val articleSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.main_bg))
            .verticalScroll(rememberScrollState())
            .padding(bottom = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header {

        }

        CategoriesBlock(
            items = state.categoriesState.items,
            selectedItem = state.categoriesState.selected,
            onCategoryClick = {
                viewModel.dispatch(WisdomAction.CategorySelect(it))
            }
        )

        BlockTitle(title = stringResource(id = R.string.news_of_the_day), paddingTop = 32)
        BlockTitle(title = stringResource(id = R.string.moon_title))
        BlockTitle(title = stringResource(id = R.string.yoga_title))
    }

}