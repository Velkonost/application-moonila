package features.onboarding.presentation.model

enum class OnboardingStep(
    val position: Int,
    val percent: Int,
    val canGoNextAfk: Boolean = true
) {
    Text1(
        position = 0,
        percent = 0
    ),
    Text2(
        position = 1,
        percent = 0
    ),
    Text3(
        position = 2,
        percent = 0
    ),
    Name(
        position = 3,
        percent = 20,
        canGoNextAfk = false
    ),
    Gender(
        position = 4,
        percent = 40,
        canGoNextAfk = false
    ),
    Age(
        position = 5,
        percent = 50
    ),
    Promo1(
        position = 6,
        percent = 60
    ),
    Promo2(
        position = 7,
        percent = 60
    ),
    Promo3(
        position = 8,
        percent = 60
    ),
    Improve(
        position = 9,
        percent = 80,
        canGoNextAfk = false
    ),
    Goals(
        position = 10,
        percent = 100,
        canGoNextAfk = false
    ),
    ProfileSettings(
        position = 11,
        percent = 100
    );

    companion object {
        fun getNextStep(step: OnboardingStep): OnboardingStep? {
            val nextPosition = step.position + 1

            return OnboardingStep.entries.firstOrNull { it.position == nextPosition }
        }
    }


}