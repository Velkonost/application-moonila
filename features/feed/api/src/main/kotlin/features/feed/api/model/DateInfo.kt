package features.feed.api.model

data class DateInfo(
    val dayOfMonth: Int,
    val dayOfWeek: Int,
    val month: Int,
    val year: Int,
    var selected: Boolean = false
)