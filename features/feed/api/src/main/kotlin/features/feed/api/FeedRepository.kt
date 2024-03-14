package features.feed.api

interface FeedRepository {

    fun increaseMonth()

    fun decreaseMonth()

    fun getMonthName(): String

    fun getCurrentDates(): List<Pair<Int, Int>>

}