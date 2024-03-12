package features.mooninsight.presentation.contract

import core.vm.contracts.UIContract
import core.vm.navigation.NavigationEvent
import core.vm.navigation.NavigationScreen

sealed interface MoonInsightNavigation: UIContract.Navigation {
    data object NavigateBack : MoonInsightNavigation, MoonInsightAction {
        override val event: NavigationEvent = NavigationEvent.NavigateUp()
    }
}