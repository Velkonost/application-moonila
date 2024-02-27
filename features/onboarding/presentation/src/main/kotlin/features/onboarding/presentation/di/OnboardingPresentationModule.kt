package features.onboarding.presentation.di

import features.onboarding.presentation.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val OnboardingPresentationModule = module {
    viewModelOf(::OnboardingViewModel)
}