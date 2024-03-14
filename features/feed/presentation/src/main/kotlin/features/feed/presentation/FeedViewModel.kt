package features.feed.presentation

import android.util.Log
import core.vm.BaseViewModel
import features.feed.api.FeedRepository
import features.feed.presentation.contract.FeedAction
import features.feed.presentation.contract.FeedEvent
import features.feed.presentation.contract.FeedNavigation
import features.feed.presentation.contract.FeedViewState
import features.feed.presentation.model.MoonTipContent
import features.feed.presentation.model.MoonTipsItem
import java.util.Calendar

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
    }

    private fun generateCalendarDates() {
        val calendar = Calendar.getInstance()
        val firstDayOfMonth = calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
        val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        val currentMonth = calendar.get(Calendar.MONTH)

        calendar.set(Calendar.DAY_OF_MONTH, firstDayOfMonth)
        val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        calendar.set(Calendar.DAY_OF_MONTH, lastDayOfMonth)
        val lastDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        Log.d("keke", "keke")

        // 1 - sunday, 7 - saturday
        // 2 - march
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
