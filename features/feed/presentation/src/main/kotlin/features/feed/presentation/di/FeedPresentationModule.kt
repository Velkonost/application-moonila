package features.feed.presentation.di

import features.feed.presentation.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val FeedPresentationModule = module {
    viewModelOf(::FeedViewModel)
}