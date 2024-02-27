package umbrella

import core.datastore.di.CoreDataStoreModule
import core.network.di.CoreNetworkModule
import features.onboarding.presentation.di.OnboardingPresentationModule
import features.splash.data.di.SplashDataModule
import features.splash.presentation.di.SplashPresentationModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration


object MoonilaSDK {

    fun init(
        modules: List<Module>? = null,
        appDeclaration: KoinAppDeclaration = {}
    ) = startKoin {
        appDeclaration()

        modules(
            CoreDataStoreModule,
            CoreNetworkModule,

            SplashDataModule,
            SplashPresentationModule,

            OnboardingPresentationModule
        )

        modules?.let(::modules)
    }
}