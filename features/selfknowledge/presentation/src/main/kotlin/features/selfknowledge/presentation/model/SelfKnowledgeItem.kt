package features.selfknowledge.presentation.model

data class SelfKnowledgeItem(
    val titleResId: Int,
    val iconId: Int,
    val generalText: String,
    val secondaryText: String,
    val points: List<SelfKnowledgeItemPoint>,
    val previewText: String,
    val colorResId: Int,
    val dividerColorResId: Int
)

data class SelfKnowledgeItemPoint(
    val iconId: Int,
    val titleResId: Int,
    val text: String
)