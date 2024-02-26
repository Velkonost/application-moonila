package core.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

// OTHER
val ONBOARDING_SHOWN = booleanPreferencesKey("onboarding_shown")

val TOKEN_KEY = stringPreferencesKey("auth_token")


val KEYS_RESET_STATE = listOf(
    ONBOARDING_SHOWN
)

val KEYS_TO_REFRESH = listOf(
    ONBOARDING_SHOWN
).plus(KEYS_RESET_STATE)