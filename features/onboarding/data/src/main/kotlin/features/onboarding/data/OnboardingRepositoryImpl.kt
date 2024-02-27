package features.onboarding.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import features.onboarding.api.OnboardingRepository

class OnboardingRepositoryImpl(
    private val localDataSource: DataStore<Preferences>
) : OnboardingRepository{

    override suspend fun completeOnboarding() {
        TODO("Not yet implemented")
    }
}