package features.profile.data.di

import features.profile.api.ProfileRepository
import features.profile.data.ProfileRepositoryImpl
import org.koin.dsl.module

val ProfileDataModule = module {
    single<ProfileRepository> {
        ProfileRepositoryImpl()
    }
}