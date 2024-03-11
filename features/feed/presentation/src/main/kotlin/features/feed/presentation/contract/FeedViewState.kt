package features.feed.presentation.contract

import core.model.MoonInsightType
import core.vm.contracts.UIContract
import features.feed.presentation.model.MoonInsightItem
import com.moonila.features.feed.presentation.R

data class FeedViewState(
    val isLoading: Boolean = false,
    val moonState: MoonState = MoonState(),
    val moonInsightState: MoonInsightState = MoonInsightState()
): UIContract.State

data class MoonState(
    val newMoonDate: String = "13 Nov at 13:29",
    val fullMoonDate: String = "27 Nov at 10:17",
    val lunarEclipseDate: String = "13 Nov at 13:29",
    val solarEclipseDate: String = "27 Nov at 10:17",
)

data class MoonInsightState(
    val items: List<MoonInsightItem> = listOf(
        MoonInsightItem(
            type = MoonInsightType.MoonDay,
            previewText = "The 25th moon day is a perfect day to take a break and enjoy some leisure time. With the lunar energy waning, it's best to avoid starting anything new and instead focus on self-care and reflection. Take the time to nurture your mind, body, and soul, and engage in activities that bring you joy and",
            number = "25",
        ),
        MoonInsightItem(
            type = MoonInsightType.MoonSign,
            previewText = "The 25th moon day is a perfect day to take a break and enjoy some leisure time. With the lunar energy waning, it's best to avoid starting anything new and instead focus on self-care and reflection. Take the time to nurture your mind, body, and soul, and engage in activities that bring you joy and",
            iconId = R.drawable.ic_zodiac_aquarius
        ),
        MoonInsightItem(
            type = MoonInsightType.MoonPhase,
            previewText = "The 25th moon day is a perfect day to take a break and enjoy some leisure time. With the lunar energy waning, it's best to avoid starting anything new and instead focus on self-care and reflection. Take the time to nurture your mind, body, and soul, and engage in activities that bring you joy and",
        )
    )
)