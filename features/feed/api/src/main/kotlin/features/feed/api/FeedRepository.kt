package features.feed.api

import features.feed.api.model.DateInfo

interface FeedRepository {

    fun increaseMonth()

    fun decreaseMonth()

    fun increaseDay()

    fun decreaseDay()

    fun setDay(dateInfo: DateInfo)

    fun getMonthName(): String

    fun getDateName(): String

    fun getCurrentDates(): List<DateInfo>

}