package features.onboarding.api

interface OnboardingRepository {

    suspend fun completeOnboarding()

}