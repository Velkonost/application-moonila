package features.selfknowledge.data.di

import features.selfknowledge.api.SelfKnowledgeRepository
import features.selfknowledge.data.SelfKnowledgeRepositoryImpl
import org.koin.dsl.module

val SelfKnowledgeDataModule = module {
    single<SelfKnowledgeRepository> {
        SelfKnowledgeRepositoryImpl()
    }
}