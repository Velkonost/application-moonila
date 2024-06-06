package features.profile.presentation.model

import androidx.annotation.StringRes
import com.moonila.features.profile.presentation.R

enum class UserGender(
    @StringRes val text: Int
) {

    Female(R.string.user_gender_female),
    Male(R.string.user_gender_male),
    Other(R.string.user_gender_other)

}