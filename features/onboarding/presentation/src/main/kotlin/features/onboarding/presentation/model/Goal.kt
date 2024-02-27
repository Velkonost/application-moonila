package features.onboarding.presentation.model

import com.moonila.features.onboarding.presentation.R

enum class Goal(
    val text: Int
) {
    Calendar(text = R.string.goal_1),
    Recognize(text = R.string.goal_2),
    Relationship(text = R.string.goal_3),
    Relieve(text = R.string.goal_4),
    Affirmations(text = R.string.goal_5),
}