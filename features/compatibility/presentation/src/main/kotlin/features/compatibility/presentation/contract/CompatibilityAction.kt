package features.compatibility.presentation.contract

import core.vm.contracts.UIContract
import features.compatibility.presentation.model.CompatibilityItem

sealed interface CompatibilityAction: UIContract.Action {

    data class ItemDelete(val value: CompatibilityItem): CompatibilityAction

    data object ClearCreation : CompatibilityAction

    sealed interface CreateCompatibilityAction : CompatibilityAction {
        data class FirstPersonNameChanged(val value: String) : CreateCompatibilityAction

        data class SecondPersonNameChanged(val value: String) : CreateCompatibilityAction

        data class FirstPersonDateChanged(val day: Int, val month: Int, val year: Int) : CreateCompatibilityAction

        data class SecondPersonDateChanged(val day: Int, val month: Int, val year: Int) : CreateCompatibilityAction

        data object CreateClick : CreateCompatibilityAction
    }
}
