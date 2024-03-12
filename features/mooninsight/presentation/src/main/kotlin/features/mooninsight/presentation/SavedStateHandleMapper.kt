package features.mooninsight.presentation

import androidx.lifecycle.SavedStateHandle
import core.util.extension.decodeFromString
import core.vm.navigation.ARG_MOON_INSIGHT_TYPE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal val SavedStateHandle.type: Flow<String>
    get() = getStateFlow<String?>(ARG_MOON_INSIGHT_TYPE, null)
        .map { it?.decodeFromString() ?: "" }