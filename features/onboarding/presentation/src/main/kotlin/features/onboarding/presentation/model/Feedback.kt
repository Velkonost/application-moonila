package features.onboarding.presentation.model

import com.moonila.features.onboarding.presentation.R

enum class Feedback(
    val title: Int,
    val text: Int,
    val author: Int
) {

    First(
        title = R.string.feedback_1_title,
        text = R.string.feedback_1_text,
        author = R.string.feedback_1_author,
    ),

    Second(
        title = R.string.feedback_2_title,
        text = R.string.feedback_2_text,
        author = R.string.feedback_2_author,
    ),

    Third(
        title = R.string.feedback_3_title,
        text = R.string.feedback_3_text,
        author = R.string.feedback_3_author,
    ),

    Forth(
        title = R.string.feedback_4_title,
        text = R.string.feedback_4_text,
        author = R.string.feedback_4_author,
    ),

    Fifth(
        title = R.string.feedback_5_title,
        text = R.string.feedback_5_text,
        author = R.string.feedback_5_author,
    ),

    Sixth(
        title = R.string.feedback_6_title,
        text = R.string.feedback_6_text,
        author = R.string.feedback_6_author,
    ),

    Seventh(
        title = R.string.feedback_7_title,
        text = R.string.feedback_7_text,
        author = R.string.feedback_7_author,
    ),

}