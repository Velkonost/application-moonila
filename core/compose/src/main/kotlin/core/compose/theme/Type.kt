package core.compose.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.moonila.core.compose.R

private val PoppinsFontFamily = FontFamily(
    listOf(
        Font(resId = R.font.poppins_medium, weight = FontWeight.Medium),
        Font(resId = R.font.poppins_regular, weight = FontWeight.Normal),
        Font(resId = R.font.poppins_semibold, weight = FontWeight.SemiBold),
        Font(resId = R.font.poppins_bold, weight = FontWeight.Bold),
        Font(resId = R.font.poppins_black, weight = FontWeight.Black)
    )
)

val BonaNovaFontFamily = FontFamily(
    listOf(
        Font(resId = R.font.bonanova_regular, weight = FontWeight.Medium),
        Font(resId = R.font.bonanova_regular, weight = FontWeight.Normal),
        Font(resId = R.font.bonanova_bold, weight = FontWeight.Bold),
        Font(resId = R.font.bonanova_bold, weight = FontWeight.Black)
    )
)

/**
 * Values taken from Google Material 3 documentation
 * [Source](https://m3.material.io/styles/typography/type-scale-tokens)
 */
@Suppress("MagicNumber")
internal val AppTypography = Typography(
    // DISPLAY .....................................................................................
    displayLarge = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        lineHeight = TextUnit(1.12F, TextUnitType.Em)
    ),
    displayMedium = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = TextUnit(1.15F, TextUnitType.Em)
    ),
    displaySmall = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = TextUnit(1.22F, TextUnitType.Em)
    ),

    // HEADLINE ....................................................................................
    headlineLarge = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = TextUnit(1.25F, TextUnitType.Em)
    ),
    headlineMedium = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = TextUnit(1.285F, TextUnitType.Em)
    ),
    headlineSmall = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = TextUnit(1.33F, TextUnitType.Em)
    ),

    // TITLE .......................................................................................
    titleLarge = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 22.sp,
        lineHeight = TextUnit(1.27F, TextUnitType.Em)
    ),
    titleMedium = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = TextUnit(1.5F, TextUnitType.Em),
        letterSpacing = TextUnit(0.009f, TextUnitType.Em)
    ),
    titleSmall = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = TextUnit(1.42F, TextUnitType.Em),
        letterSpacing = TextUnit(0.007f, TextUnitType.Em)
    ),

    // LABEL .......................................................................................
    labelLarge = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = TextUnit(1.42F, TextUnitType.Em),
        letterSpacing = TextUnit(0.007f, TextUnitType.Em)
    ),
    labelMedium = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = TextUnit(1.33F, TextUnitType.Em),
        letterSpacing = TextUnit(0.03f, TextUnitType.Em)
    ),
    labelSmall = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        lineHeight = TextUnit(1.45F, TextUnitType.Em),
        letterSpacing = TextUnit(0.045f, TextUnitType.Em)
    ),

    // BODY ........................................................................................
    bodyLarge = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = TextUnit(1.5F, TextUnitType.Em),
        letterSpacing = TextUnit(0.03f, TextUnitType.Em)
    ),
    bodyMedium = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = TextUnit(1.42F, TextUnitType.Em),
        letterSpacing = TextUnit(0.015f, TextUnitType.Em)
    ),
    bodySmall = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = TextUnit(1.33F, TextUnitType.Em),
        letterSpacing = TextUnit(0.033f, TextUnitType.Em)
    )
)
