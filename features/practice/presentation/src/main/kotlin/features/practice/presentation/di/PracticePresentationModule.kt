package features.practice.presentation.di

import features.practice.presentation.PracticeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val PracticePresentationModule = module {
    viewModelOf(::PracticeViewModel)
}