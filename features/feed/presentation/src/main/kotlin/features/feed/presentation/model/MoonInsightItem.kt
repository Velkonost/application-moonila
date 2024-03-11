package features.feed.presentation.model

import core.model.MoonInsightType

data class MoonInsightItem(
    val type: MoonInsightType,
    val previewText: String,

    val number: String? = null,
    val iconId: Int? = null
)