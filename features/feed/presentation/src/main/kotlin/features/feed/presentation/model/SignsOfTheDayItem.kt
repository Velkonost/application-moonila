package features.feed.presentation.model

data class SignsOfTheDayItem(
    val titleId: Int,
    val subtitle: String,
    val text: String,
    val icon1Id: Int? = null,
    val colors: List<Int>? = null
)