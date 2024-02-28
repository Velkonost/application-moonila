package core.compose.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
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

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState()
    val borderModifier = modifier.border(
        width = 1.dp,
        color = colorResource(
            id = if (isFocused.value) R.color.light_color
            else R.color.unfocused_tf_border
        ),
        shape = MaterialTheme.shapes.medium
    )

    BasicTextField(
        value = value,
        onValueChange = onValueChanged,
        interactionSource = interactionSource,
        singleLine = true,
        modifier = borderModifier.background(
            color = Color.Transparent,
            shape = MaterialTheme.shapes.medium
        )
    ) {
        TextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = it,
            singleLine = true,
            label = {
                Text(
                    text = placeholderText,
                    color = colorResource(id = R.color.common_text_color),
                    fontFamily = PoppinsFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            },
            enabled = true,
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            colors = TextFieldDefaults.colors()
        )
    }

//    OutlinedTextField(
//        value = value,
//        onValueChange = {
//            onValueChanged.invoke(it)
//        },
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(PaddingValues(horizontal = 16.dp))
//            .height(54.dp)
//            .clip(shape = MaterialTheme.shapes.medium),
//        textStyle = TextStyle(
//            fontFamily = PoppinsFontFamily,
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Normal
//        ),
//        maxLines = 1,
//        label = {
//            Text(
//                text = placeholderText,
//                color = colorResource(id = R.color.common_text_color),
//                style = TextStyle(
//                    fontFamily = PoppinsFontFamily,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Normal
//                )
//            )
//        },
//        colors = OutlinedTextFieldDefaults.colors(
//            disabledContainerColor = Color.Transparent,
//            unfocusedContainerColor = Color.Transparent,
//            focusedContainerColor = Color.Transparent,
//            cursorColor = colorResource(id = R.color.light_color),
//            focusedBorderColor = colorResource(id = R.color.light_color),
//            unfocusedBorderColor = colorResource(id = R.color.unfocused_tf_border)
//        ),
//        enabled = isEnabled
//    )
}