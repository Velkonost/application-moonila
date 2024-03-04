package features.paywall.presentation.model

import com.moonila.features.paywall.presentation.R

enum class Offer(
    val title: Int,
    val text: Int,
    val hint: Int,
    val discount: Int? = null
) {

    Week(
        title = R.string.offer_week_title,
        text = R.string.offer_week_text,
        hint = R.string.offer_week_hint
    ),

    Lifetime(
        title = R.string.offer_lifetime_title,
        text = R.string.offer_lifetime_text,
        hint = R.string.offer_lifetime_hint,
        discount = R.string.offer_lifetime_discount
    )

}