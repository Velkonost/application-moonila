package core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import core.datastore.DataStoreFileName
import core.datastore.createDataStore
import org.koin.dsl.module

val CoreDataStoreModule = module {
    single { dataStore(get()) }
}

fun dataStore(context: Context): DataStore<Preferences> =
    createDataStore(
        producePath = { context.filesDir.resolve(DataStoreFileName).absolutePath }
    )