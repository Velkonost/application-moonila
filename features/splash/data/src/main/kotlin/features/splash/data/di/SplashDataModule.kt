package features.splash.data.di

import features.splash.api.SplashRepository
import features.splash.data.SplashRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val SplashDataModule = module {
    single<SplashRepository> {
        SplashRepositoryImpl()
    }
}