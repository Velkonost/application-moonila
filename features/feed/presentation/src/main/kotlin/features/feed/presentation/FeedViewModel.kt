package features.feed.presentation

import com.moonila.features.feed.presentation.R
import core.vm.BaseViewModel
import features.feed.api.FeedRepository
import features.feed.api.model.DateInfo
import features.feed.presentation.contract.FeedAction
import features.feed.presentation.contract.FeedEvent
import features.feed.presentation.contract.FeedNavigation
import features.feed.presentation.contract.FeedViewState
import features.feed.presentation.model.CalendarDate
import features.feed.presentation.model.MoonTipContent
import features.feed.presentation.model.MoonTipsItem

class FeedViewModel
internal constructor(
    private val feedRepository: FeedRepository
) : BaseViewModel<FeedViewState, FeedAction, FeedNavigation, FeedEvent>(
    initialState = FeedViewState()
) {

    init {
        setupCurrentDate()
        generateCalendarDates()
    }

    override fun dispatch(action: FeedAction) = when (action) {
        is FeedAction.MoonInsightClick -> emit(FeedNavigation.NavigateToMoonInsight(action.value))
        is FeedAction.MoonTipsClick -> obtainMoonTipsClick(action.value)
        is FeedAction.PrevDayClick -> obtainPrevDayClick()
        is FeedAction.NextDayClick -> obtainNextDayClick()
        is FeedAction.PrevMonthClick -> obtainPrevMonthClick()
        is FeedAction.NextMonthClick -> obtainNextMonthClick()
        is FeedAction.DateSelect -> obtainDateSelect(action.value)
    }

    private fun generateCalendarDates() {
        launchJob {
            val dates = feedRepository.getCurrentDates().map {
                CalendarDate(
                    iconId = R.drawable.ic_slider_moon,
                    number = if (it.dayOfMonth < 10) "0${it.dayOfMonth}" else it.dayOfMonth.toString(),
                    dayOfWeek = it.dayOfWeek,
                    year = it.year,
                    month = it.month,
                    selected = it.selected
                )
            }

            val calendarState = viewState.value.calendarState.copy(
                monthLabel = feedRepository.getMonthName(),
                missedDaysAmount = dates.first().dayOfWeek - 1,
                items = dates
            )
            emit(viewState.value.copy(calendarState = calendarState))
        }
    }

    private fun setupCurrentDate() {
        val calendarState =
            viewState.value.calendarState.copy(selectedDateLabel = feedRepository.getDateName())
        emit(viewState.value.copy(calendarState = calendarState))
    }

    private fun obtainDateSelect(value: CalendarDate) {
        launchJob {
            with(value) {
                val dateInfo = DateInfo(
                    dayOfMonth = number.toInt(),
                    dayOfWeek = dayOfWeek,
                    month, year, selected
                )

                feedRepository.setDay(dateInfo)
                setupCurrentDate()
                generateCalendarDates()
            }
        }
    }

    private fun obtainNextDayClick() {
        feedRepository.increaseDay()
        setupCurrentDate()
        generateCalendarDates()
    }

    private fun obtainPrevDayClick() {
        feedRepository.decreaseDay()
        setupCurrentDate()
        generateCalendarDates()
    }

    private fun obtainNextMonthClick() {
        feedRepository.increaseMonth()
        generateCalendarDates()
    }

    private fun obtainPrevMonthClick() {
        feedRepository.decreaseMonth()
        generateCalendarDates()
    }

    private fun obtainMoonTipsClick(value: MoonTipsItem) {
        val moonTipsState = viewState.value.moonTipsState.copy(
            selectedItem = MoonTipContent(
                type = value,
                text = "Scelerisque quam egestas dictum vulputate etiam at. Purus porttitor sed nulla in dui felis urna arcu eget. Lectus fermentum pharetra ut in fermentum. Arcu faucibus viverra gravida sed pellentesque pharetra dolor. Dolor laoreet dolor arcu augue molestie ac platea. Neque ac tortor."
            )
        )
        emit(viewState.value.copy(moonTipsState = moonTipsState))
    }

}
