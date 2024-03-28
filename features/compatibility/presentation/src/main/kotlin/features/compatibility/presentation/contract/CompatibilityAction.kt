package features.compatibility.presentation.contract

import core.vm.contracts.UIContract
import features.compatibility.presentation.model.CompatibilityItem

sealed interface CompatibilityAction: UIContract.Action {

    data class ItemDelete(val value: CompatibilityItem): CompatibilityAction
}
