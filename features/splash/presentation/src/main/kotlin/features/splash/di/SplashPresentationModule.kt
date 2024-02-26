package features.splash.di

import features.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val SplashPresentationModule = module {
    viewModelOf(::SplashViewModel)
}