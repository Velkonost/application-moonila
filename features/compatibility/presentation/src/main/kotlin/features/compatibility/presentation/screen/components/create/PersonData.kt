package features.compatibility.presentation.screen.components.create

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.features.compatibility.presentation.R
import core.compose.components.SingleLineTextField
import core.compose.composable.orangeTextGradient
import core.compose.theme.BonaNovaFontFamily
import core.compose.theme.PoppinsFontFamily
import features.compatibility.presentation.contract.PersonErrors
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColumnScope.PersonData(
    modifier: Modifier = Modifier,
    title: String,
    name: String,
    gender: String,
    date: String,
    errors: PersonErrors,
    onNameChanged: (String) -> Unit,
    onGenderClick: () -> Unit,
    onDateClick: () -> Unit
) {

    Text(
        modifier = modifier.padding(top = 24.dp),
        text = title,
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Medium,
        style = orangeTextGradient(fontSize = 20.sp)
    )

    SingleLineTextField(
        modifier = modifier.padding(top = 16.dp),
        value = name,
        placeholderText = stringResource(id = R.string.create_name_hint),
        onValueChanged = onNameChanged,
        onClearClick = {
            onNameChanged("")
        }
    )

    if (errors.name) {
        PersonDataError()
    }

    SingleLineTextField(
        modifier = modifier.padding(top = 12.dp),
        value = gender,
        placeholderText = stringResource(id = R.string.create_gender_hint),
        onValueChanged = {  },
        isEnabled = false,
        forceShowIcon = true,
        icon = painterResource(id = R.drawable.ic_create_compatibility_arrow),
        onClearClick = {
            onGenderClick()
        }
    )

    if (errors.gender) {
        PersonDataError()
    }

    SingleLineTextField(
        modifier = modifier.padding(top = 12.dp),
        value = date,
        placeholderText = stringResource(id = R.string.create_date_hint),
        onValueChanged = {  },
        isEnabled = false,
        forceShowIcon = true,
        icon = painterResource(id = R.drawable.ic_create_compatibility_arrow),
        onClearClick = {
            onDateClick()
        }
    )

    if (errors.date) {
        PersonDataError()
    }


}

@Composable
fun PersonDataError(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier.size(14.dp),
            painter = painterResource(id = R.drawable.ic_compatibility_creation_error),
            contentDescription = null
        )

        Text(
            modifier = modifier.padding(start = 6.dp, top = 2.dp),
            text = stringResource(id = R.string.this_field_is_required),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = colorResource(id = com.moonila.core.compose.R.color.light_color)
        )
    }

}