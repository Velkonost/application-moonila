package features.profile.presentation.contract

import core.vm.contracts.UIContract

sealed interface ProfileAction: UIContract.Action {

    data class SetUpNotification(val index: Int, val value: String?) : ProfileAction

    data class ClearNotification(val index: Int): ProfileAction

}