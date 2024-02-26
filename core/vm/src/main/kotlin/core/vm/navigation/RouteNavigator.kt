package core.vm.navigation

import kotlinx.coroutines.flow.SharedFlow

interface RouteNavigator {
    val navigationEvent: SharedFlow<NavigationEvent>
}