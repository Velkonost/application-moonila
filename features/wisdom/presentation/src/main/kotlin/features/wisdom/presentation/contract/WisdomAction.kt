package features.wisdom.presentation.contract

import core.vm.contracts.UIContract
import features.wisdom.presentation.model.CategoryItem

sealed interface WisdomAction: UIContract.Action {

    data class CategorySelect(val value: CategoryItem) : WisdomAction

}