package features.splash.data

import features.splash.api.SplashRepository

class SplashRepositoryImpl(

): SplashRepository {

    override suspend fun showOnboarding(): Boolean {
        return true
    }
}