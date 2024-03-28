package features.compatibility.presentation

import core.vm.BaseViewModel
import features.compatibility.api.CompatibilityRepository
import features.compatibility.presentation.contract.CompatibilityAction
import features.compatibility.presentation.contract.CompatibilityEvent
import features.compatibility.presentation.contract.CompatibilityNavigation
import features.compatibility.presentation.contract.CompatibilityViewState
import features.compatibility.presentation.model.CompatibilityItem

class CompatibilityViewModel
internal constructor(
    private val compatibilityRepository: CompatibilityRepository
) : BaseViewModel<CompatibilityViewState, CompatibilityAction, CompatibilityNavigation, CompatibilityEvent>(
    initialState = CompatibilityViewState()
) {
    override fun dispatch(action: CompatibilityAction) = when(action) {
        is CompatibilityAction.ItemDelete -> obtainItemDelete(action.value)
        else -> {

        }
    }


    private fun obtainItemDelete(value: CompatibilityItem) {
        val items = viewState.value.items.toMutableList()
        items.remove(value)
        emit(viewState.value.copy(items = items))
    }

}