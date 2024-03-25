package features.wisdom.data.di

import features.wisdom.api.WisdomRepository
import features.wisdom.data.WisdomRepositoryImpl
import org.koin.dsl.module

val WisdomDataModule = module {
    single<WisdomRepository> {
        WisdomRepositoryImpl()
    }
}