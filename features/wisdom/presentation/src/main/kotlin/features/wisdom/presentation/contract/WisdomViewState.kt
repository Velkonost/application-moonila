package features.wisdom.presentation.contract

import core.vm.contracts.UIContract
import features.wisdom.presentation.model.CategoryItem

data class WisdomViewState(
    val isLoading: Boolean = false,
    val categoriesState: CategoriesState = CategoriesState()
): UIContract.State

data class CategoriesState(
    val items: List<CategoryItem> = CategoryItem.entries,
    val selected: CategoryItem = items.first()
)