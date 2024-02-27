package features.splash.api

fun interface SplashRepository {

    suspend fun showOnboarding(): Boolean

}