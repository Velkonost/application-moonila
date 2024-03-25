package features.practice.data.di

import features.practice.api.PracticeRepository
import features.practice.data.PracticeRepositoryImpl
import org.koin.dsl.module

val PracticeDataModule = module {
    single<PracticeRepository> {
        PracticeRepositoryImpl()
    }
}