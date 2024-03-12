package features.mooninsight.presentation

import androidx.lifecycle.SavedStateHandle
import core.model.MoonInsightType
import core.model.MoonInsightType.Companion.nextStep
import core.vm.BaseViewModel
import features.mooninsight.presentation.contract.MoonInsightAction
import features.mooninsight.presentation.contract.MoonInsightEvent
import features.mooninsight.presentation.contract.MoonInsightNavigation
import features.mooninsight.presentation.contract.MoonInsightViewState
import features.mooninsight.presentation.model.MoonDayContent
import features.mooninsight.presentation.model.MoonPhaseContent
import features.mooninsight.presentation.model.MoonSignContent
import kotlinx.coroutines.flow.collectLatest

class MoonInsightViewModel
internal constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<MoonInsightViewState, MoonInsightAction, MoonInsightNavigation, MoonInsightEvent>(
    initialState = MoonInsightViewState(),
    savedStateHandle = savedStateHandle
) {

    private val type = savedStateHandle.type.stateInWhileSubscribed(initialValue = "")

    init {
        launchJob {
            type.collectLatest { typeName ->
                val selectedType = MoonInsightType.entries.firstOrNull { it.name == typeName }
                    ?: MoonInsightType.MoonDay
                emit(
                    viewState.value.copy(
                        type = selectedType,
                        content = when (selectedType) {
                            MoonInsightType.MoonDay -> MoonDayContent
                            MoonInsightType.MoonSign -> MoonSignContent
                            MoonInsightType.MoonPhase -> MoonPhaseContent
                        }
                    )
                )
            }
        }
    }

    override fun dispatch(action: MoonInsightAction) = when (action) {
        is MoonInsightNavigation.NavigateBack -> emit(action)
        is MoonInsightAction.NextStepClick -> obtainNextStep()
    }

    private fun obtainNextStep() {
        val nextStep = viewState.value.type.nextStep()
        if (nextStep == null) {
            emit(MoonInsightNavigation.NavigateBack)
        } else {
            emit(
                viewState.value.copy(
                    type = nextStep,
                    content = when (nextStep) {
                        MoonInsightType.MoonDay -> MoonDayContent
                        MoonInsightType.MoonSign -> MoonSignContent
                        MoonInsightType.MoonPhase -> MoonPhaseContent
                    }
                )
            )
        }
    }

}
