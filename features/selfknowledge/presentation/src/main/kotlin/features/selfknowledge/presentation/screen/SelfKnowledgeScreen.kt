package features.selfknowledge.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.selfknowledge.presentation.SelfKnowledgeViewModel
import com.moonila.features.selfknowledge.presentation.R
import features.selfknowledge.presentation.screen.components.Header

@Composable
fun SelfKnowledgeScreen(
    modifier: Modifier = Modifier,
    viewModel: SelfKnowledgeViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.main_bg))
            .verticalScroll(rememberScrollState())
            .padding(bottom = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            name = state.userName,
            subtitle = state.userData
        )
    }

}