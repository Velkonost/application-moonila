package features.onboarding.presentation.model

import com.moonila.features.onboarding.presentation.R

enum class Improve(
    val text: Int
) {
    Life(text = R.string.improve_1),
    Finance(text = R.string.improve_2),
    Career(text = R.string.improve_3),
    Relationship(text = R.string.improve_4),
    Other(text = R.string.improve_5),
}