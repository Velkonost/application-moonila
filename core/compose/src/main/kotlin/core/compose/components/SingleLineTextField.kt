package core.compose.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
    onClearClick: (() -> Unit)? = null
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState()
    val textColor = colorResource(id = R.color.light_color)

    Box {
        BasicTextField(
            value = value,
            onValueChange = onValueChanged,
            interactionSource = interactionSource,
            singleLine = true,
            textStyle = TextStyle(
                fontFamily = PoppinsFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = textColor
            ),
            cursorBrush = SolidColor(colorResource(id = R.color.light_color)),
            modifier = modifier
                .fillMaxWidth()
                .padding(PaddingValues(horizontal = 16.dp))
                .border(
                    width = 1.dp,
                    color = colorResource(
                        id = if (isFocused.value) R.color.light_color
                        else R.color.unfocused_tf_border
                    ),
                    shape = MaterialTheme.shapes.medium
                )
                .height(54.dp)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(
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
                        fontSize = if (isFocused.value || value.isNotEmpty()) 12.sp else 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                enabled = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = textColor,
                    unfocusedTextColor = textColor,
                    disabledContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.light_color),
                )
            )
        }

        if (onClearClick != null && value.isNotEmpty()) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(54.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .padding(end = 32.dp)
                        .size(24.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onClearClick
                        ),
                    painter = painterResource(id = R.drawable.ic_cross_round),
                    contentDescription = null
                )
            }
        }

    }
}