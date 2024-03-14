package features.feed.presentation.model

data class CalendarDate(
    val iconId: Int,
    val number: String,
    val selected: Boolean = false,
    val dayOfWeek: Int,
)