package features.paywall.presentation.di

import features.paywall.presentation.PaywallViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val PaywallPresentationModule = module {
    singleOf(::PaywallViewModel)
}