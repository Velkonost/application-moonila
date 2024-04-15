package features.feed.data

import features.feed.api.FeedRepository
import features.feed.api.model.DateInfo
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FeedRepositoryImpl : FeedRepository {

    private val calendar: Calendar = Calendar.getInstance()
    private val dayCalendar: Calendar = Calendar.getInstance()


    override fun getMonthName(): String {
        return monthFullNameSDF.format(calendar.time)
    }

    override fun getDateName(): String {
        return dayFullNameSDF.format(dayCalendar.time)
    }

    override fun increaseMonth() {
        calendar.add(Calendar.MONTH, 1)
    }

    override fun decreaseMonth() {
        calendar.add(Calendar.MONTH, -1)
    }

    override fun increaseDay() {
        dayCalendar.add(Calendar.DATE, 1)
        val currentMonthOfDate = dayCalendar.get(Calendar.MONTH)
        val currentMonth = calendar.get(Calendar.MONTH)

        if (currentMonthOfDate > currentMonth) {
            increaseMonth()
        }
    }

    override fun decreaseDay() {
        dayCalendar.add(Calendar.DATE, -1)

        val currentMonthOfDate = dayCalendar.get(Calendar.MONTH)
        val currentMonth = calendar.get(Calendar.MONTH)

        if (currentMonthOfDate < currentMonth) {
            decreaseMonth()
        }
    }

    override fun setDay(dateInfo: DateInfo) {
        with(dateInfo) {
            dayCalendar.set(Calendar.YEAR, year)
            dayCalendar.set(Calendar.MONTH, month)
            dayCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }
    }

    override fun getCurrentDates(): List<DateInfo> {
        val result = mutableListOf<DateInfo>()
        val firstDayOfMonth = calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
        val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        val selectedDateInfo = DateInfo(
            dayOfMonth = dayCalendar.get(Calendar.DAY_OF_MONTH),
            dayOfWeek = dayCalendar.get(Calendar.DAY_OF_WEEK),
            month = dayCalendar.get(Calendar.MONTH),
            year = dayCalendar.get(Calendar.YEAR),
        )

        for (day in firstDayOfMonth..lastDayOfMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, day)
            calendar.get(Calendar.DAY_OF_WEEK).also {
                val dateInfo = DateInfo(
                    dayOfMonth = day,
                    dayOfWeek = it,
                    month = calendar.get(Calendar.MONTH),
                    year = calendar.get(Calendar.YEAR),
                )
                dateInfo.selected = dateInfo == selectedDateInfo
                result.add(dateInfo)
            }
        }

        return result
    }

    companion object {
        private const val MONTH_FULL_NAME_FORMAT = "MMMM, YYYY"
        private const val DAY_FULL_NAME_FORMAT = "dd MMM, EEE"

        private val monthFullNameSDF = SimpleDateFormat(MONTH_FULL_NAME_FORMAT, Locale.US)
        private val dayFullNameSDF = SimpleDateFormat(DAY_FULL_NAME_FORMAT, Locale.US)
    }

}