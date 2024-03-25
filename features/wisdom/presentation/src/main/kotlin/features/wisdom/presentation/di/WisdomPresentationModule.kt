package features.wisdom.presentation.di

import features.wisdom.presentation.WisdomViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val WisdomPresentationModule = module {
    viewModelOf(::WisdomViewModel)
}