package features.compatibility.presentation.di

import features.compatibility.presentation.CompatibilityViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val CompatibilityPresentationModule = module {
    viewModelOf(::CompatibilityViewModel)
}