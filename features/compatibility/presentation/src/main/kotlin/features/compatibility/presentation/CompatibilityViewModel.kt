package features.compatibility.presentation

import core.vm.BaseViewModel
import features.compatibility.api.CompatibilityRepository
import features.compatibility.presentation.contract.CompatibilityAction
import features.compatibility.presentation.contract.CompatibilityEvent
import features.compatibility.presentation.contract.CompatibilityNavigation
import features.compatibility.presentation.contract.CompatibilityViewState
import features.compatibility.presentation.contract.CreateCompatibilityViewState
import features.compatibility.presentation.contract.PersonDate
import features.compatibility.presentation.contract.PersonGender
import features.compatibility.presentation.model.CompatibilityItem

class CompatibilityViewModel
internal constructor(
    private val compatibilityRepository: CompatibilityRepository
) : BaseViewModel<CompatibilityViewState, CompatibilityAction, CompatibilityNavigation, CompatibilityEvent>(
    initialState = CompatibilityViewState()
) {
    override fun dispatch(action: CompatibilityAction) = when (action) {
        is CompatibilityAction.ItemDelete -> obtainItemDelete(action.value)
        is CompatibilityAction.CreateCompatibilityAction.FirstPersonNameChanged -> obtainFirstPersonNameChanged(
            action.value
        )

        is CompatibilityAction.CreateCompatibilityAction.SecondPersonNameChanged -> obtainSecondPersonNameChanged(
            action.value
        )

        is CompatibilityAction.CreateCompatibilityAction.FirstPersonDateChanged -> obtainFirstPersonDateChanged(
            action.day,
            action.month,
            action.year
        )

        is CompatibilityAction.CreateCompatibilityAction.SecondPersonDateChanged -> obtainSecondPersonDateChanged(
            action.day,
            action.month,
            action.year
        )

        is CompatibilityAction.CreateCompatibilityAction.FirstPersonGenderChanged -> obtainFirstPersonGenderChanged(
            action.index,
            action.label
        )

        is CompatibilityAction.CreateCompatibilityAction.SecondPersonGenderChanged -> obtainSecondPersonGenderChanged(
            action.index,
            action.label
        )

        is CompatibilityAction.CreateCompatibilityAction.CreateClick -> obtainCreateFormClick()
        is CompatibilityAction.ClearCreation -> clearForm()
        else -> {

        }
    }


    private fun obtainItemDelete(value: CompatibilityItem) {
        val items = viewState.value.items.toMutableList()
        items.removeIf { it.id == value.id }
        emit(viewState.value.copy(items = items))
    }

    private fun obtainFirstPersonNameChanged(value: String) {
        with(viewState.value.createCompatibilityViewState) {
            val createCompatibilityViewState = copy(
                firstPersonName = value,
                firstPersonErrors = firstPersonErrors.copy(name = value.isNotEmpty())
            )
            emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
        }
        validateCreationForm()
    }

    private fun obtainSecondPersonNameChanged(value: String) {
        with(viewState.value.createCompatibilityViewState) {
            val createCompatibilityViewState = copy(
                secondPersonName = value,
                secondPersonErrors = secondPersonErrors.copy(name = value.isNotEmpty())
            )
            emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
        }
        validateCreationForm()
    }

    private fun obtainFirstPersonDateChanged(day: Int, month: Int, year: Int) {
        with(viewState.value.createCompatibilityViewState) {
            val createCompatibilityViewState = copy(
                firstPersonDate = PersonDate(
                    label = "$day.$month.$year",
                    year, month, day
                ),
                firstPersonErrors = firstPersonErrors.copy(date = false)
            )
            emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
        }
        validateCreationForm()
    }

    private fun obtainSecondPersonDateChanged(day: Int, month: Int, year: Int) {
        with(viewState.value.createCompatibilityViewState) {
            val createCompatibilityViewState = copy(
                secondPersonDate = PersonDate(
                    label = "$day.$month.$year",
                    year, month, day
                ),
                secondPersonErrors = secondPersonErrors.copy(date = false)
            )
            emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
        }
        validateCreationForm()
    }

    private fun obtainFirstPersonGenderChanged(index: Int, label: String) {
        with(viewState.value.createCompatibilityViewState) {
            val createCompatibilityViewState = copy(
                firstPersonGender = PersonGender(label, index),
                firstPersonErrors = firstPersonErrors.copy(gender = false)
            )
            emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
        }
        validateCreationForm()
    }

    private fun obtainSecondPersonGenderChanged(index: Int, label: String) {
        with(viewState.value.createCompatibilityViewState) {
            val createCompatibilityViewState = copy(
                secondPersonGender = PersonGender(label, index),
                secondPersonErrors = secondPersonErrors.copy(gender = false)
            )
            emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
        }
        validateCreationForm()
    }

    private fun validateCreationForm() {
        with(viewState.value.createCompatibilityViewState) {
            val firstPersonEligible =
                firstPersonDate.label.isNotEmpty() && firstPersonGender.label.isNotEmpty() && firstPersonName.isNotEmpty()
            val secondPersonEligible =
                secondPersonDate.label.isNotEmpty() && secondPersonGender.label.isNotEmpty() && secondPersonName.isNotEmpty()

            val createCompatibilityViewState = this.copy(
                eligible = firstPersonEligible && secondPersonEligible
            )
            emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
        }
    }

    private fun obtainCreateFormClick() {
        with(viewState.value.createCompatibilityViewState) {
            if (eligible) {
                clearForm()
                emit(CompatibilityEvent.CreatedSuccess)
            } else {
                val firstPersonErrors = firstPersonErrors.copy(
                    name = firstPersonName.isEmpty(),
                    gender = firstPersonGender.label.isEmpty(),
                    date = firstPersonDate.label.isEmpty()
                )
                val secondPersonErrors = secondPersonErrors.copy(
                    name = secondPersonName.isEmpty(),
                    gender = secondPersonGender.label.isEmpty(),
                    date = secondPersonDate.label.isEmpty()
                )
                val createCompatibilityViewState =
                    viewState.value.createCompatibilityViewState.copy(
                        firstPersonErrors = firstPersonErrors,
                        secondPersonErrors = secondPersonErrors
                    )
                emit(viewState.value.copy(createCompatibilityViewState = createCompatibilityViewState))
            }
        }
    }

    private fun clearForm() {
        emit(viewState.value.copy(createCompatibilityViewState = CreateCompatibilityViewState()))
    }

}