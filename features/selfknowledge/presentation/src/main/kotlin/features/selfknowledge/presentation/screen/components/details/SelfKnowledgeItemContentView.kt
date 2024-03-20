package features.selfknowledge.presentation.screen.components.details

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.selfknowledge.presentation.R
import core.compose.theme.PoppinsFontFamily
import features.selfknowledge.presentation.model.SelfKnowledgeItemContent


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