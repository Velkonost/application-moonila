package features.feed.presentation.contract

import core.model.MoonInsightType
import core.util.extension.encodeToString
import core.vm.contracts.UIContract
import core.vm.navigation.ARG_MOON_INSIGHT_TYPE
import core.vm.navigation.NavigationEvent
import core.vm.navigation.NavigationScreen

sealed interface FeedNavigation: UIContract.Navigation {
    data class NavigateToMoonInsight(val type: MoonInsightType) : FeedNavigation {
        override val event: NavigationEvent = NavigationEvent.NavigateToRoute(
            route = NavigationScreen.MoonInsightNavScreen.route,
            args = hashMapOf(ARG_MOON_INSIGHT_TYPE to type.name.encodeToString())
        )
    }
}