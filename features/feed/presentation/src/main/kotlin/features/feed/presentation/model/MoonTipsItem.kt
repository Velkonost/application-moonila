package features.feed.presentation.model

import com.moonila.features.feed.presentation.R

enum class MoonTipsItem(
    val titleResId: Int,
    val iconId: Int,
    val inactiveIconId: Int
) {
    Health(
        titleResId = R.string.moon_tips_health,
        iconId = R.drawable.ic_tips_health,
        inactiveIconId = R.drawable.ic_tips_health_inactive
    ),

    Business(
        titleResId = R.string.moon_tips_business,
        iconId = R.drawable.ic_tips_business,
        inactiveIconId = R.drawable.ic_tips_business_inactive
    ),

    Beauty(
        titleResId = R.string.moon_tips_beauty,
        iconId = R.drawable.ic_tips_beauty,
        inactiveIconId = R.drawable.ic_tips_beauty_inactive
    ),

    Nutrition(
        titleResId = R.string.moon_tips_nutrition,
        iconId = R.drawable.ic_tips_nutrition,
        inactiveIconId = R.drawable.ic_tips_nutrition_inactive
    ),

    Relations(
        titleResId = R.string.moon_tips_relations,
        iconId = R.drawable.ic_tips_relations,
        inactiveIconId = R.drawable.ic_tips_relations_inactive
    ),
}

data class MoonTipContent(
    val type: MoonTipsItem,
    val text: String
)
