package features.compatibility.presentation

import core.vm.BaseViewModel
import features.compatibility.api.CompatibilityRepository
import features.compatibility.presentation.contract.CompatibilityAction
import features.compatibility.presentation.contract.CompatibilityEvent
import features.compatibility.presentation.contract.CompatibilityNavigation
import features.compatibility.presentation.contract.CompatibilityViewState
import features.compatibility.presentation.contract.PersonDate
import features.compatibility.presentation.contract.PersonGender
import features.compatibility.presentation.model.CompatibilityItem

class CompatibilityViewModel
internal constructor(
    private val compatibilityRepository: CompatibilityRepository
) : BaseViewModel<CompatibilityViewState, CompatibilityAction, CompatibilityNavigation, CompatibilityEvent>(
    initialState = CompatibilityViewState()
) {
    override fun dispatch(action: CompatibilityAction) = when(action) {
        is CompatibilityAction.ItemDelete -> obtainItemDelete(action.value)
        is CompatibilityAction.CreateCompatibilityAction.FirstPersonNameChanged -> obtainFirstPersonNameChanged(action.value)
        is CompatibilityAction.CreateCompatibilityAction.SecondPersonNameChanged -> obtainSecondPersonNameChanged(action.value)
        is CompatibilityAction.CreateCompatibilityAction.FirstPersonDateChanged -> obtainFirstPersonDateChanged(action.day, action.month, action.year)
        is CompatibilityAction.CreateCompatibilityAction.SecondPersonDateChanged -> obtainSecondPersonDateChanged(action.day, action.month, action.year)
        is CompatibilityAction.CreateCompatibilityAction.FirstPersonGenderChanged -> obtainFirstPersonGenderChanged(action.index, action.label)
        is CompatibilityAction.CreateCompatibilityAction.SecondPersonGenderChanged -> obtainSecondPersonGenderChanged(action.index, action.label)
        is CompatibilityAction.CreateCompatibilityAction.CreateClick -> TODO()
        else -> {

        }
    }


    private fun obtainItemDelete(value: CompatibilityItem) {
        val items = viewState.value.items.toMutableList()
        items.removeIf { it.id == value.id }
        emit(viewState.value.copy(items = items))
    }

    private fun obtainFirstPersonNameChanged(value: String) {
        val createCompatibilityViewState = viewState.value.createCompatibilityViewState.copy(
            firstPersonName = value
        )
        emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
    }

    private fun obtainSecondPersonNameChanged(value: String) {
        val createCompatibilityViewState = viewState.value.createCompatibilityViewState.copy(
            secondPersonName = value
        )
        emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
    }

    private fun obtainFirstPersonDateChanged(day: Int, month: Int, year: Int) {
        val createCompatibilityViewState = viewState.value.createCompatibilityViewState.copy(
            firstPersonDate = PersonDate(
                label = "$day.$month.$year",
                year, month, day
            )
        )
        emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
    }

    private fun obtainSecondPersonDateChanged(day: Int, month: Int, year: Int) {
        val createCompatibilityViewState = viewState.value.createCompatibilityViewState.copy(
            secondPersonDate = PersonDate(
                label = "$day.$month.$year",
                year, month, day
            )
        )
        emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
    }

    private fun obtainFirstPersonGenderChanged(index: Int, label: String) {
        val createCompatibilityViewState = viewState.value.createCompatibilityViewState.copy(
            firstPersonGender = PersonGender(label, index)
        )
        emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
    }

    private fun obtainSecondPersonGenderChanged(index: Int, label: String) {
        val createCompatibilityViewState = viewState.value.createCompatibilityViewState.copy(
            secondPersonGender = PersonGender(label, index)
        )
        emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
    }
}