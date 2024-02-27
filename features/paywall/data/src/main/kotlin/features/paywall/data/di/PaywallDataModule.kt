package features.paywall.data.di

import features.paywall.api.PaywallRepository
import features.paywall.data.PaywallRepositoryImpl
import org.koin.dsl.module

val PaywallDataModule = module {
    single<PaywallRepository> {
        PaywallRepositoryImpl()
    }
}