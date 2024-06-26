package features.paywall.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moonila.features.paywall.presentation.R
import core.compose.components.AppGradientButton
import core.compose.theme.PoppinsFontFamily
import features.paywall.presentation.PaywallViewModel
import features.paywall.presentation.contract.PaywallAction
import features.paywall.presentation.screen.components.FeedBackItem
import features.paywall.presentation.screen.components.FooterView
import features.paywall.presentation.screen.components.OfferItem
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PaywallScreen(
    modifier: Modifier = Modifier,
    viewModel: PaywallViewModel
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val scrollState = rememberLazyListState()

    val feedbackDuration = 5000L

    LaunchedEffect(Unit) {
        while (true) {
            delay(feedbackDuration)
            val currentPosition = scrollState.firstVisibleItemIndex
            val nextPosition = (currentPosition + 1) % state.feedbacks.size
            scrollState.animateScrollToItem(nextPosition)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.ic_bg), contentScale = ContentScale.Crop)
    ) {

        Column(
            modifier = modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier
                    .padding(top = 50.dp)
                    .width(78.dp),
                painter = painterResource(id = R.drawable.ic_pw_logo),
                contentDescription = null
            )

            Image(
                modifier = modifier
                    .padding(top = 24.dp)
                    .width(152.dp),
                painter = painterResource(id = R.drawable.ic_paywall),
                contentDescription = null
            )

            LazyRow(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                state = scrollState,
                flingBehavior = rememberSnapFlingBehavior(lazyListState = scrollState),
                userScrollEnabled = false
            ) {
                items(state.feedbacks, key = { it.name }) {
                    FeedBackItem(item = it)
                }
            }

            Spacer(modifier.weight(1f))

            state.offers.forEach {
                OfferItem(
                    item = it,
                    selected = it == state.selectedOffer,
                    onClick = {
                        viewModel.dispatch(PaywallAction.OfferSelect(it))
                    }
                )
            }

            Text(
                modifier = modifier
                    .padding(top = 18.dp),
                text = stringResource(id = state.selectedOffer.hint),
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.offer_hint_color)
            )

            AppGradientButton(
                modifier = modifier
                    .padding(top = 18.dp),
                label = stringResource(id = com.moonila.core.compose.R.string.continue_btn),
                onClick = {

                }
            )

            Spacer(modifier.height(16.dp))

            FooterView(
                onPrivacyClick = { },
                onTermsClick = {

                },
                onRestoreClick = {

                }
            )

            Spacer(modifier.weight(1f))
        }
    }
    
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            modifier = modifier
                .padding(top = 40.dp, start = 16.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.ic_pw_close),
            contentDescription = null 
        )
    }
}

