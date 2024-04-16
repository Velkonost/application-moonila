package com.commandiron.wheel_picker_compose.core

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun WheelTextPicker(
    modifier: Modifier = Modifier,
    startIndex: Int = 0,
    size: DpSize = DpSize(128.dp, 128.dp),
    texts: List<String>,
    rowCount: Int,
    style: TextStyle = MaterialTheme.typography.titleMedium,
    color: Color = LocalContentColor.current,
    selectorProperties: SelectorProperties = WheelPickerDefaults.selectorProperties(),
    onScrollFinished: (snappedIndex: Int) -> Int? = { null },
    alignStart: Boolean = false
) {
    WheelPicker(
        modifier = modifier,
        startIndex = startIndex,
        size = size,
        count = 1000,//texts.size,
        rowCount = rowCount,
        selectorProperties = selectorProperties,
        onScrollFinished = onScrollFinished
    ){ index ->
        if (alignStart) {
            Row {
                Text(
                    text = texts[index % texts.size],
                    style = style,
                    color = color,
                    maxLines = 1,
                    textAlign = TextAlign.Start
                )
                Spacer(Modifier.weight(1f))
            }
        } else {
            Text(
                text = texts[index % texts.size],
                style = style,
                color = color,
                maxLines = 1,
                textAlign = TextAlign.Start
            )
        }
    }
}