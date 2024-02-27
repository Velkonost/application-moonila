package features.splash.api

interface SplashRepository {

    suspend fun showOnboarding(): Boolean

}