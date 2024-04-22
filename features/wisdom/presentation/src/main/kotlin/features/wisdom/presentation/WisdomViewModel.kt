package features.wisdom.presentation

import core.vm.BaseViewModel
import features.wisdom.api.WisdomRepository
import features.wisdom.presentation.contract.CategoriesState
import features.wisdom.presentation.contract.WisdomAction
import features.wisdom.presentation.contract.WisdomEvent
import features.wisdom.presentation.contract.WisdomNavigation
import features.wisdom.presentation.contract.WisdomViewState
import features.wisdom.presentation.model.CategoryItem

class WisdomViewModel
internal constructor(
    private val wisdomRepository: WisdomRepository
) : BaseViewModel<WisdomViewState, WisdomAction, WisdomNavigation, WisdomEvent>(
    initialState = WisdomViewState()
) {
    override fun dispatch(action: WisdomAction) = when(action) {
        is WisdomAction.CategorySelect -> obtainCategorySelect(action.value)
        else -> {

        }
    }

    private fun obtainCategorySelect(value: CategoryItem) {
        val categoriesState = viewState.value.categoriesState.copy(selected = value)
        emit(viewState.value.copy(categoriesState = categoriesState))
    }


}