package features.onboarding.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import core.datastore.ONBOARDING_SHOWN
import features.onboarding.api.OnboardingRepository

class OnboardingRepositoryImpl(
    private val localDataSource: DataStore<Preferences>
) : OnboardingRepository{

    override suspend fun completeOnboarding() {
        localDataSource.edit { preferences ->
            preferences[ONBOARDING_SHOWN] = true
        }
    }
}