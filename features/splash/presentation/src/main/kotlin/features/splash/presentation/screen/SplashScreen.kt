package features.splash.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import features.splash.presentation.SplashViewModel
import com.moonila.features.splash.presentation.R

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    @Suppress("unused") viewModel: SplashViewModel
) {

    val state = viewModel.viewState.collectAsStateWithLifecycle()


    Box {
        Image(
            painter = painterResource(R.drawable.bg_splash),
            contentDescription = null
        )
    }

}