package features.compatibility.presentation.model

import java.util.UUID

data class CompatibilityItem(
    val id: String = UUID.randomUUID().toString(),
    val firstName: String,
    val secondName: String,
    val percent: String,
    val firstMoonIcon: Int,
    val secondMoonIcon: Int,
    val firstSignIcon: Int,
    val secondSignIcon: Int
)