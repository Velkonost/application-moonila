package features.feed.presentation.contract

import core.vm.contracts.UIContract

data class FeedViewState(
    val isLoading: Boolean = false,
    val moonState: MoonState = MoonState()
): UIContract.State

data class MoonState(
    val newMoonDate: String = "13 Nov at 13:29",
    val fullMoonDate: String = "27 Nov at 10:17",
    val lunarEclipseDate: String = "13 Nov at 13:29",
    val solarEclipseDate: String = "27 Nov at 10:17",
)