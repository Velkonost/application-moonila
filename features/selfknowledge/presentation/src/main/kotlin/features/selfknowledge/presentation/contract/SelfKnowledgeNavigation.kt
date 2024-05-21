package features.selfknowledge.presentation.contract

import core.model.MoonInsightType
import core.util.extension.encodeToString
import core.vm.contracts.UIContract
import core.vm.navigation.ARG_MOON_INSIGHT_TYPE
import core.vm.navigation.NavigationEvent
import core.vm.navigation.NavigationScreen

sealed interface SelfKnowledgeNavigation: UIContract.Navigation {

    data object NavigateToProfile : SelfKnowledgeNavigation, SelfKnowledgeAction {
        override val event: NavigationEvent = NavigationEvent.NavigateToRoute(
            route = NavigationScreen.ProfileNavScreen.route,
        )
    }
}