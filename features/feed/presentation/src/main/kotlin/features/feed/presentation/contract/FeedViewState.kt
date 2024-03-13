package features.feed.presentation.contract

import core.model.MoonInsightType
import core.vm.contracts.UIContract
import features.feed.presentation.model.MoonInsightItem
import features.feed.presentation.model.MoonTipContent
import features.feed.presentation.model.MoonTipsItem
import com.moonila.features.feed.presentation.R

data class FeedViewState(
    val isLoading: Boolean = false,
    val moonState: MoonState = MoonState(),
    val moonInsightState: MoonInsightState = MoonInsightState(),
    val quoteState: QuoteState = QuoteState(),
    val moonTipsState: MoonTipsState = MoonTipsState(),
    val dailyTipState: DailyTipState = DailyTipState(),
    val affirmationState: AffirmationState = AffirmationState()
) : UIContract.State

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
            iconId = com.moonila.core.compose.R.drawable.ic_zodiac_aquarius
        ),
        MoonInsightItem(
            type = MoonInsightType.MoonPhase,
            previewText = "The 25th moon day is a perfect day to take a break and enjoy some leisure time. With the lunar energy waning, it's best to avoid starting anything new and instead focus on self-care and reflection. Take the time to nurture your mind, body, and soul, and engage in activities that bring you joy and",
        )
    )
)

data class QuoteState(
    val text: String = "“If you want others to be happy, practice compassion. If you want to be happy, practice compassion”",
    val author: String = "-Dalai Lama"
)

data class MoonTipsState(
    val items: List<MoonTipsItem> = MoonTipsItem.entries,
    val selectedItem: MoonTipContent = MoonTipContent(
        type = items.first(),
        text = "Scelerisque quam egestas dictum vulputate etiam at. Purus porttitor sed nulla in dui felis urna arcu eget. Lectus fermentum pharetra ut in fermentum. Arcu faucibus viverra gravida sed pellentesque pharetra dolor. Dolor laoreet dolor arcu augue molestie ac platea. Neque ac tortor."
    )
)

data class DailyTipState(
    val iconId: Int = R.drawable.ic_daily_tip,
    val title: String = "Wednesday",
    val text: String = "Wednesday is favorable for meeting friends and business partners, signing contracts, resolving financial matters, and taking exams. It's a good day for networking and communication; new acquaintances might turn into lasting friendships."
)

data class AffirmationState(
    val titleIconId: Int = R.drawable.ic_slider_moon,
    val title: String = "Affirmation for Moon in Virgo",
    val text: String = "I feel connected to nature and the universe. They fill me with energy and strength"
)