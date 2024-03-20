package features.selfknowledge.presentation.screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.moonila.features.selfknowledge.presentation.R
import core.compose.theme.BonaNovaFontFamily
import core.compose.theme.PoppinsFontFamily
import features.selfknowledge.presentation.model.SelfKnowledgeItem
import features.selfknowledge.presentation.model.SelfKnowledgeItemContent
import features.selfknowledge.presentation.screen.components.details.DetailsHeader
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelfKnowledgeDetailsSheet(
    modifier: Modifier = Modifier,
    modalSheetState: ModalBottomSheetState,
    item: SelfKnowledgeItem
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
        sheetBackgroundColor = colorResource(id = item.colorResId),
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f),
            ) {

                DetailsHeader(title = stringResource(id = item.titleResId)) {
                    scope.launch {
                        modalSheetState.hide()
                    }
                }

                Box(
                    modifier = modifier
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 100.dp)
                ) {
                    Image(
                        modifier = modifier
                            .align(Alignment.TopCenter)
                            .size(300.dp)
                            .offset(y = (-50).dp)
                            .zIndex(0f),
                        painter = painterResource(id = item.detailsIconId),
                        contentDescription = null
                    )

                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .padding(top = 180.dp)
                            .padding(horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = item.generalText,
                            fontFamily = BonaNovaFontFamily,
                            fontWeight = FontWeight.Bold,
                            style = TextStyle(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        colorResource(id = R.color.name_gradient_1),
                                        colorResource(id = R.color.name_gradient_2),
                                        colorResource(id = R.color.name_gradient_3),
                                    ),
                                    tileMode = TileMode.Clamp
                                ),
                                fontSize = 24.sp
                            ),
                        )

                        Text(
                            modifier = modifier.padding(top = 2.dp),
                            text = item.secondaryText,
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = com.moonila.core.compose.R.color.light_color),
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center
                        )

                        Box(
                            modifier = modifier
                                .alpha(0.5f)
                                .padding(top = 16.dp)
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(
                                    color = colorResource(id = item.dividerColorResId),
                                    shape = MaterialTheme.shapes.medium
                                )
                        )

                        Row(
                            modifier = modifier
                                .padding(top = 20.dp)
                        ) {
                            item.points.forEach {
                                PointView(item = it)
                            }
                        }

                        Box(
                            modifier = modifier
                                .alpha(0.5f)
                                .padding(top = 20.dp)
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(
                                    color = colorResource(id = item.dividerColorResId),
                                    shape = MaterialTheme.shapes.medium
                                )
                        )

                        Spacer(modifier.height(4.dp))

                        item.content.forEach {
                            SelfKnowledgeItemContentView(item = it)
                        }
                    }
                }
            }
        }
    ) {}
}

@Composable
fun ColumnScope.SelfKnowledgeItemContentView(
    modifier: Modifier = Modifier,
    item: SelfKnowledgeItemContent
) {

    Spacer(modifier.height(20.dp))

    item.title?.let {
        Text(
            modifier = modifier.align(Alignment.Start),
            text = it,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.cloudy_color),
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
    }

    if (item.title.isNullOrEmpty().not() && item.text.isNullOrEmpty().not()) {
        Spacer(modifier.height(12.dp))
    }

    item.text?.let {
        Text(
            modifier = modifier.align(Alignment.Start),
            text = it,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.cloudy_color),
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
    }
}