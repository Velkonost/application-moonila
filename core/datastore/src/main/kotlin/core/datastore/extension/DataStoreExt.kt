package core.datastore.extension

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import core.datastore.KEYS_RESET_STATE
import core.datastore.KEYS_TO_REFRESH
import core.datastore.TOKEN_KEY
import kotlinx.coroutines.flow.first

suspend fun DataStore<Preferences>.getUserToken(): String? = data.first()[TOKEN_KEY]

suspend fun DataStore<Preferences>.clear() = this.edit { preferences ->
    KEYS_TO_REFRESH.forEach { key ->
        preferences.remove(key)
    }
}

suspend fun DataStore<Preferences>.resetStates() = this.edit { preferences ->
    KEYS_RESET_STATE.forEach { key ->
        preferences[key] = true
    }
}