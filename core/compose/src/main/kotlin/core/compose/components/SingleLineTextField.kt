package core.compose.components


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moonila.core.compose.R
import core.compose.theme.PoppinsFontFamily

@Composable
fun SingleLineTextField(
    modifier: Modifier = Modifier,
    value: String,
    isEnabled: Boolean = true,
    placeholderText: String,
    onValueChanged: (String) -> Unit,
    onClearClick: () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChanged.invoke(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(PaddingValues(horizontal = 16.dp))
            .height(54.dp)
            .clip(shape = MaterialTheme.shapes.medium),
        textStyle = TextStyle(
            fontFamily = PoppinsFontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        maxLines = 1,
        label = {
            Text(
                text = placeholderText,
                color = colorResource(id = R.color.common_text_color),
                style = TextStyle(
                    fontFamily = PoppinsFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            disabledContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            cursorColor = colorResource(id = R.color.light_color),
            focusedBorderColor = colorResource(id = R.color.light_color),
            unfocusedBorderColor = colorResource(id = R.color.unfocused_tf_border)
        ),
        enabled = isEnabled
    )
}