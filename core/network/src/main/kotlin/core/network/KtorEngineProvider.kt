package core.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import java.util.concurrent.TimeUnit

internal fun withPlatformEngine(
    config: HttpClientConfig<*>.() -> Unit
) = HttpClient(OkHttp) {
    config(this)
    engine {
        config {
            retryOnConnectionFailure(true)
            connectTimeout(KTOR_REQUEST_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
        }
    }
}