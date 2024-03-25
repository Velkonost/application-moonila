package features.compatibility.data.di

import features.compatibility.api.CompatibilityRepository
import features.compatibility.data.CompatibilityRepositoryImpl
import org.koin.dsl.module

val CompatibilityDataModule = module {
    single<CompatibilityRepository> {
        CompatibilityRepositoryImpl()
    }
}