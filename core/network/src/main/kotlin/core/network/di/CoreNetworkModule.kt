package core.network.di

import core.network.KtorClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val CoreNetworkModule = module {
    singleOf(::KtorClient)
}