package features.mooninsight.presentation.di

import features.mooninsight.presentation.MoonInsightViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val MoonInsightPresentationModule = module {
    viewModelOf(::MoonInsightViewModel)
}