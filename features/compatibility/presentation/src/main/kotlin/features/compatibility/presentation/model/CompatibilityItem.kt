package features.compatibility.presentation.model

data class CompatibilityItem(
    val firstName: String,
    val secondName: String,
    val percent: String,
    val firstMoonIcon: Int,
    val secondMoonIcon: Int,
    val firstSignIcon: Int,
    val secondSignIcon: Int
)