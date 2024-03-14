package umbrella

import core.datastore.di.CoreDataStoreModule
import core.network.di.CoreNetworkModule
import features.feed.data.di.FeedDataModule
import features.feed.presentation.di.FeedPresentationModule
import features.mooninsight.presentation.di.MoonInsightPresentationModule
import features.onboarding.data.di.OnboardingDataModule
import features.onboarding.presentation.di.OnboardingPresentationModule
import features.paywall.data.di.PaywallDataModule
import features.paywall.presentation.di.PaywallPresentationModule
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

            OnboardingDataModule,
            OnboardingPresentationModule,

            PaywallDataModule,
            PaywallPresentationModule,

            FeedDataModule,
            FeedPresentationModule,
            MoonInsightPresentationModule
        )

        modules?.let(::modules)
    }
}