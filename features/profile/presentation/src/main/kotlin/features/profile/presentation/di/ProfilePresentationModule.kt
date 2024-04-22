package features.profile.presentation.di

import features.profile.presentation.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val ProfilePresentationModule = module {
    viewModelOf(::ProfileViewModel)
}