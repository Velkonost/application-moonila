package features.feed.presentation.model

enum class MoonTipsItem(
    val titleResId: Int,
    val iconId: Int,
    val inactiveIconId: Int
)

data class MoonTipContent(
    val type: MoonTipsItem,
    val text: String
)
