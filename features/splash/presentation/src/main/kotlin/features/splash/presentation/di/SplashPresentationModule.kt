package features.splash.presentation.di

import features.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val SplashPresentationModule = module {
    viewModelOf(::SplashViewModel)
}