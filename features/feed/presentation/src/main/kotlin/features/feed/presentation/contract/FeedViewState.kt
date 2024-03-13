package features.feed.presentation.contract

import core.model.MoonInsightType
import core.vm.contracts.UIContract
import features.feed.presentation.model.MoonInsightItem
import features.feed.presentation.model.MoonTipContent
import features.feed.presentation.model.MoonTipsItem
import com.moonila.features.feed.presentation.R
import features.feed.presentation.model.SignsOfTheDayItem

data class FeedViewState(
    val isLoading: Boolean = false,
    val moonState: MoonState = MoonState(),
    val moonInsightState: MoonInsightState = MoonInsightState(),
    val quoteState: QuoteState = QuoteState(),
    val moonTipsState: MoonTipsState = MoonTipsState(),
    val dailyTipState: DailyTipState = DailyTipState(),
    val affirmationState: AffirmationState = AffirmationState(),
    val signsOfTheDayState: SignsOfTheDayState = SignsOfTheDayState()
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

data class SignsOfTheDayState(
    val items: List<SignsOfTheDayItem> = listOf(
        SignsOfTheDayItem(
            titleId = R.string.color_of_the_day,
            subtitle = "Yellow, Purple & Blue",
            text = "Every day according to the lunar calendar has its own color that will bring luck. For this, it must be present either in clothing or in jewelry.",
        ),

        SignsOfTheDayItem(
            titleId = R.string.lucky_minerals,
            subtitle = "Red granite",
            text = "Specific minerals effectively transform and convey the energy of a particular lunar day to a person. They have maximum potency on that lunar day. It's recommended to wear amulets and jewelry corresponding to the lunar day for luck and a favorable day.",
            icon1Id = R.drawable.ic_lucky_mineral_redgranite,
        ),

        SignsOfTheDayItem(
            titleId = R.string.planet_of_the_day,
            subtitle = "Venus",
            text = "Venus embodies beauty, creativity, harmony, and love. Friday is an excellent day for self-care, focusing on your health, and cleansing your body. Postpone serious tasks and important events to another day. Dedicate your time to socializing with friends and loved ones. It's a wonderful day for parties, declarations of feelings, romantic dates, and expressing love to the world. Treat yourself and your loved ones with gifts. Embrace the beautiful things in life: attend the theater, museum, or an art exhibition, or watch a great movie.",
            icon1Id = R.drawable.ic_planet_of_the_day_venus,
        ),
    )
)