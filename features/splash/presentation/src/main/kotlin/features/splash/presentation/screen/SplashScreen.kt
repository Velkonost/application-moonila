package features.splash.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moonila.features.splash.presentation.R
import core.compose.composable.OrangeTextGradient
import core.compose.theme.BonaNovaFontFamily
import features.splash.presentation.SplashViewModel

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    @Suppress("unused") viewModel: SplashViewModel
) {

    val state = viewModel.viewState.collectAsStateWithLifecycle()


    Box {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(R.drawable.bg_splash),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier.weight(1f))
            Image(
                modifier = modifier.size(73.dp),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null
            )

            Text(
                modifier = modifier.padding(top = 20.dp),
                text = stringResource(id = R.string.splash_title),
                fontFamily = BonaNovaFontFamily,
                fontWeight = FontWeight.Bold,
                style = OrangeTextGradient(fontSize = 24.sp)
            )
            Spacer(modifier.weight(1f))
        }

    }

}