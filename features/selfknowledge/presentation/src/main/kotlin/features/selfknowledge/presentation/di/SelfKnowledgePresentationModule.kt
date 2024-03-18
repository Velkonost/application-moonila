package features.selfknowledge.presentation.di

import features.selfknowledge.presentation.SelfKnowledgeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val SelfKnowledgePresentationModule = module {
    viewModelOf(::SelfKnowledgeViewModel)
}