package features.feed.presentation

import android.util.Log
import com.moonila.features.feed.presentation.R
import core.vm.BaseViewModel
import features.feed.api.FeedRepository
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
        generateCalendarDates()
    }

    override fun dispatch(action: FeedAction) = when (action) {
        is FeedAction.MoonInsightClick -> emit(FeedNavigation.NavigateToMoonInsight(action.value))
        is FeedAction.MoonTipsClick -> obtainMoonTipsClick(action.value)
        is FeedAction.PrevDayClick -> TODO()
        is FeedAction.NextDayClick -> TODO()
        is FeedAction.PrevMonthClick -> obtainPrevMonthClick()
        is FeedAction.NextMonthClick -> obtainNextMonthClick()
    }

    private fun generateCalendarDates() {
        launchJob {
            val dates = feedRepository.getCurrentDates().map {
                CalendarDate(
                    iconId = R.drawable.ic_slider_moon,
                    number = it.first.run { if (it.first < 10) "0${it.first}" else it.first.toString() },
                    dayOfWeek = it.second
                )
            }

            val calendarState = viewState.value.calendarState.copy(
                monthLabel = feedRepository.getMonthName(),
                missedDaysAmount = dates.first().dayOfWeek - 1,
                items = dates
            )
            emit(viewState.value.copy(calendarState = calendarState))

            Log.d("ekke", "keke")
            // 1 - sunday, 7 - saturday
            // 2 - march
        }
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
