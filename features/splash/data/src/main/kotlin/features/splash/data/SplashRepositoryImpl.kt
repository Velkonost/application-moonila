package features.splash.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import core.datastore.ONBOARDING_SHOWN
import features.splash.api.SplashRepository
import kotlinx.coroutines.flow.first

class SplashRepositoryImpl(
    private val localDataSource: DataStore<Preferences>
): SplashRepository {

    override suspend fun showOnboarding(): Boolean {
        val data = localDataSource.data.first()
        return data[ONBOARDING_SHOWN] != true
    }
}