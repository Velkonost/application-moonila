package features.feed.data.di

import features.feed.api.FeedRepository
import features.feed.data.FeedRepositoryImpl
import org.koin.dsl.module

val FeedDataModule = module {
    single<FeedRepository> {
        FeedRepositoryImpl()
    }
}