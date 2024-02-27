package features.onboarding.presentation.model

import com.moonila.features.onboarding.presentation.R

enum class Gender(
    val text: Int
) {

    She(text = R.string.gender_1),
    He(text = R.string.gender_2),
    They(text = R.string.gender_3),
    Other(text = R.string.gender_4)

}