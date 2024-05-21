package features.profile.presentation.contract

import core.vm.contracts.UIContract
import core.vm.navigation.NavigationEvent

sealed interface ProfileNavigation: UIContract.Navigation {
    data object NavigateBack : ProfileNavigation, ProfileAction {
        override val event: NavigationEvent = NavigationEvent.NavigateUp()
    }
}