package features.compatibility.presentation.contract

import com.moonila.features.compatibility.presentation.R
import core.vm.contracts.UIContract
import features.compatibility.presentation.model.CompatibilityItem

data class CompatibilityViewState(
    val isLoading: Boolean = false,
    val items: List<CompatibilityItem> = SampleItems,
    val createCompatibilityViewState: CreateCompatibilityViewState = CreateCompatibilityViewState()
): UIContract.State

data class CreateCompatibilityViewState(
    val firstPersonName: String = "",
    val secondPersonName: String = ""
)

val SampleItems: List<CompatibilityItem>
    get() = listOf(
        CompatibilityItem(
            firstName = "Maksim",
            secondName = "Anastasia",
            percent = 38.9f,
            firstMoonIcon = com.moonila.core.compose.R.drawable.ic_loonar,
            secondMoonIcon = com.moonila.core.compose.R.drawable.ic_full_moon,
            firstSignIcon = R.drawable.ic_first_sign,
            secondSignIcon = R.drawable.ic_second_sign
        ),
        CompatibilityItem(
            firstName = "Maksim",
            secondName = "AnastasiaAnastasia",
            percent = 98.9f,
            firstMoonIcon = com.moonila.core.compose.R.drawable.ic_loonar,
            secondMoonIcon = com.moonila.core.compose.R.drawable.ic_full_moon,
            firstSignIcon = R.drawable.ic_first_sign,
            secondSignIcon = R.drawable.ic_second_sign
        ),
        CompatibilityItem(
            firstName = "Maksim",
            secondName = "AnastasiaAnastasia",
            percent = 98.9f,
            firstMoonIcon = com.moonila.core.compose.R.drawable.ic_loonar,
            secondMoonIcon = com.moonila.core.compose.R.drawable.ic_full_moon,
            firstSignIcon = R.drawable.ic_first_sign,
            secondSignIcon = R.drawable.ic_second_sign
        ),
        CompatibilityItem(
            firstName = "Maksim",
            secondName = "AnastasiaAnastasia",
            percent = 98.9f,
            firstMoonIcon = com.moonila.core.compose.R.drawable.ic_loonar,
            secondMoonIcon = com.moonila.core.compose.R.drawable.ic_full_moon,
            firstSignIcon = R.drawable.ic_first_sign,
            secondSignIcon = R.drawable.ic_second_sign
        ),CompatibilityItem(
            firstName = "Maksim",
            secondName = "AnastasiaAnastasia",
            percent = 98.9f,
            firstMoonIcon = com.moonila.core.compose.R.drawable.ic_loonar,
            secondMoonIcon = com.moonila.core.compose.R.drawable.ic_full_moon,
            firstSignIcon = R.drawable.ic_first_sign,
            secondSignIcon = R.drawable.ic_second_sign
        ),
        CompatibilityItem(
            firstName = "Maksim",
            secondName = "AnastasiaAnastasia",
            percent = 98.9f,
            firstMoonIcon = com.moonila.core.compose.R.drawable.ic_loonar,
            secondMoonIcon = com.moonila.core.compose.R.drawable.ic_full_moon,
            firstSignIcon = R.drawable.ic_first_sign,
            secondSignIcon = R.drawable.ic_second_sign
        ),

    )