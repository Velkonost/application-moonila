package features.mooninsight.presentation.contract

import core.model.MoonInsightType
import core.vm.contracts.UIContract

data class MoonInsightViewState(
    val isLoading: Boolean = false,
    val type: MoonInsightType = MoonInsightType.MoonDay,
    val content: List<ContentBlock> = emptyList()
): UIContract.State

data class ContentBlock(
    val title: String,
    val text: String,

    val number: String? = null,
    val hint: String? = null,
    val iconId: Int? = null
)