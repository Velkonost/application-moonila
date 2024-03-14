package features.feed.data

import features.feed.api.FeedRepository
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FeedRepositoryImpl : FeedRepository {

    private val calendar: Calendar = Calendar.getInstance()

    init {
    }

    private fun getCurrentMonth(): Int {
        return calendar.get(Calendar.MONTH)
    }

    override fun getMonthName(): String {
        return monthFullNameSDF.format(calendar.time)
    }

    override fun increaseMonth() {
        calendar.add(Calendar.MONTH, 1)
    }

    override fun decreaseMonth() {
        calendar.add(Calendar.MONTH, -1)
    }

    override fun getCurrentDates(): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()
        val firstDayOfMonth = calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
        val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        for (day in firstDayOfMonth..lastDayOfMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, day)
            calendar.get(Calendar.DAY_OF_WEEK).also {
                result.add(day to it)
            }
        }

        return result
    }

    companion object {
        private const val MONTH_FULL_NAME_FORMAT = "MMMM"
        private val monthFullNameSDF = SimpleDateFormat(MONTH_FULL_NAME_FORMAT, Locale.US)
    }

}