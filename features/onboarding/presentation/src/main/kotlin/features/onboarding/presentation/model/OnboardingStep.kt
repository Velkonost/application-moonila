package features.onboarding.presentation.model

enum class OnboardingStep(
    val position: Int
) {
    Text1(position = 0),
    Text2(position = 1),
    Text3(position = 2),
    Name(position = 3),
    Gender(position = 4),
    Age(position = 5),
    Promo1(position = 6),
    Promo2(position = 7),
    Promo3(position = 8),
    Improve(position = 9),
    Goals(position = 10),
    ProfileSettings(position = 11);

    companion object {
        fun getNextStep(step: OnboardingStep): OnboardingStep? {
            val nextPosition = step.position + 1

            return OnboardingStep.entries.firstOrNull { it.position == nextPosition }
        }
    }
}