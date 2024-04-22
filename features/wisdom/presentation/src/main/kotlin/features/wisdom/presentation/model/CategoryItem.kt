package features.wisdom.presentation.model

import com.moonila.features.wisdom.presentation.R

enum class CategoryItem(
    val titleResId: Int,
    val iconId: Int,
) {

    All(
        titleResId = R.string.category_all,
        iconId = R.drawable.ic_wisdom_favorite
    ),

    Moon(
        titleResId = R.string.category_moon,
        iconId = R.drawable.ic_wisdom_favorite
    ),

    Tarot(
        titleResId = R.string.category_tarot,
        iconId = R.drawable.ic_wisdom_favorite
    ),

    Runes(
        titleResId = R.string.category_runes,
        iconId = R.drawable.ic_wisdom_favorite
    ),
}