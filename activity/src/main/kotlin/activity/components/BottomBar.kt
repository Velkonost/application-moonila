package activity.components

import activity.di.NavigationScreens
import activity.model.MenuItem
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.moonila.features.compatibility.presentation.R
import core.compose.NavRoute
import core.compose.theme.PoppinsFontFamily

@Composable
fun BottomBar(
    navController: NavHostController,
    forceHideBottomBar: MutableState<Boolean>
) {

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    val haptic = LocalHapticFeedback.current

    val isVisible = currentDestination?.route in NavigationScreens.map { it.route }
    AnimatedVisibility(
        visible = isVisible && !forceHideBottomBar.value,
        enter = slideInVertically(
            animationSpec = tween(
                durationMillis = 100,
                easing = FastOutSlowInEasing
            ),
            initialOffsetY = { it }
        ).plus(
            fadeIn(
                animationSpec = tween(
                    durationMillis = 150,
                    easing = FastOutSlowInEasing
                )
            )
        ),
        exit = slideOutVertically(
            animationSpec = tween(
                durationMillis = 100,
                easing = FastOutSlowInEasing
            ),
            targetOffsetY = { it }
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .background(
                    color = colorResource(id = com.moonila.activity.R.color.bottom_bar_bg),
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp
                    )
                ),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            val items = NavigationScreens zip MenuItem.entries.toList()
            items.forEach { item ->
                BottomBarItem(
                    item.first, item.second, currentDestination, navController, haptic
                )
            }
        }
    }

}

@Composable
fun RowScope.BottomBarItem(
    screen: NavRoute<*>,
    menuItem: MenuItem,
    currentDestination: NavDestination?,
    navController: NavHostController,
    haptic: HapticFeedback
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    Column(
        modifier = Modifier
            .weight(1f)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                if (navController.currentDestination?.route == screen.route) {
                    return@clickable
                }

                haptic.performHapticFeedback(HapticFeedbackType.LongPress)

                navController.navigate("${screen.route}_root") {
                    launchSingleTop = true
                    restoreState = true

                    val navigationRoutes = NavigationScreens
                        .map { it.route }
                    val firstBottomBarDestination = navController.currentBackStack.value
                        .firstOrNull { navigationRoutes.contains(it.destination.route) }
                        ?.destination

                    if (firstBottomBarDestination != null) {
                        popUpTo(firstBottomBarDestination.id) {
                            inclusive = false
                            saveState = true
                        }
                    }
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = if (selected) menuItem.activeIconResId else menuItem.iconResId),
            contentDescription = null,
        )

        Text(
            text = stringResource(id = menuItem.labelResId),
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = if (selected) menuItem.colorResId else com.moonila.activity.R.color.menu_item_inactive_color),
            fontSize = 10.sp,
            lineHeight = 12.sp,
            letterSpacing = 0.12.sp,
            textAlign = TextAlign.Center
        )
    }

}

