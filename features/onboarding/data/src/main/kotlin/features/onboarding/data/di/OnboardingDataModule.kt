package features.onboarding.data.di

import features.onboarding.api.OnboardingRepository
import features.onboarding.data.OnboardingRepositoryImpl
import org.koin.dsl.module

val OnboardingDataModule = module {
    single<OnboardingRepository> {
        OnboardingRepositoryImpl(get())
    }
}