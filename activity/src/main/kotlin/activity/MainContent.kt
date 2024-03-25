package activity

import activity.components.BottomBar
import activity.components.MainSnackBarHost
import activity.components.rememberSnackBarHostState
import activity.di.AppScreens
import activity.di.addCompatibilityRoute
import activity.di.addFeedRoute
import activity.di.addSelfKnowledgeRoute
import activity.di.addSplashRoute
import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.core.os.bundleOf
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.velkonost.getbetter.android.activity.components.bottomBarEnter
import com.velkonost.getbetter.android.activity.components.bottomBarExit
import core.compose.provide
import core.compose.theme.ApplicationTheme
import core.vm.navigation.NavigationScreen
import core.vm.resource.MessageDeque
import kotlinx.coroutines.flow.collectLatest


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun MainContent() {
    val context = LocalContext.current
    val navController = rememberAnimatedNavController()
    val snackBarHostState = rememberSnackBarHostState()

    val forceHideBottomBar = remember { mutableStateOf(false) }
    val localFocusManager = LocalFocusManager.current

    val firebaseAnalytics = remember {
        FirebaseAnalytics.getInstance(context)
    }

    ApplicationTheme {
        Scaffold(
            snackbarHost = { MainSnackBarHost(snackBarHostState) },
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        localFocusManager.clearFocus()
                    })
                },
            bottomBar = {
                BottomBar(navController)
            },
//            containerColor = colorResource(resource = SharedR.colors.main_background)
        ) {
            AnimatedNavHost(
                navController = navController,
                startDestination = "${NavigationScreen.SplashNavScreen.route}_root",
                enterTransition = { bottomBarEnter() },
                exitTransition = { bottomBarExit() }
            ) {
                AppScreens.provide(this@AnimatedNavHost, navController, forceHideBottomBar)
                addSplashRoute(navController, forceHideBottomBar)
                addFeedRoute(navController, forceHideBottomBar)
                addSelfKnowledgeRoute(navController, forceHideBottomBar)
                addCompatibilityRoute(navController, forceHideBottomBar)
            }
        }
    }

    LaunchedEffect(Unit) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val params = bundleOf(FirebaseAnalytics.Param.SCREEN_NAME to destination.route)
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, params)
        }
    }

    LaunchedEffect(Unit) {
        MessageDeque().collectLatest {
            onMessageReceived(it, snackBarHostState, context)
        }
    }
}
