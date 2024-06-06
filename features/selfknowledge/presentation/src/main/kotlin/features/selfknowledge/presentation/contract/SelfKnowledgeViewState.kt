package features.selfknowledge.presentation.contract

import com.moonila.features.selfknowledge.presentation.R
import core.vm.contracts.UIContract
import features.selfknowledge.presentation.model.SelfKnowledgeItem
import features.selfknowledge.presentation.model.SelfKnowledgeItemContent
import features.selfknowledge.presentation.model.SelfKnowledgeItemPoint

data class SelfKnowledgeViewState(
    val isLoading: Boolean = false,
    val userName: String = "Maksim Mironov",
    val userData: String = "Born May 11, 1994 at 10:13 am,\nNovosibirsk, Russia",
    val items: List<SelfKnowledgeItem> = SampleItems
) : UIContract.State

val SampleContent: List<SelfKnowledgeItemContent>
    get() = listOf(
        SelfKnowledgeItemContent(
            title = "Lorem Ipsum dolor sit amet",
            text = "People born on the 1st lunar day possess an exceptionally strong power of thought. You are emotional, have abundant internal energy, and often tend to be long-lived. People like you are frequently sensitive to natural cycles and are characterized by determination, humility, and kindness. Despite your years, you often appear youthful, and your behavior may have a playful touch. As optimists and cheerful individuals, you must avoid being reclusive or overly modest."
        ),

        SelfKnowledgeItemContent(
            title = "Consectetur adipsing elit",
            text = "The task associated with your lunar day, symbolized by the \"Lamp or Luminary,\" suggests that setting and achieving goals is crucial. You should embrace being in the spotlight, not fearing self-expression, both creatively and intellectually. Such individuals like you need to shine, spreading goodness in the world, and making a daily practice of wishing well to others and the world. By doing so, the power of these lunar days can aid in the realization of goals and intentions."
        ),

        SelfKnowledgeItemContent(
            text = "You should be cautious with physical exertion, as there is a high likelihood of injury. Maintaining good health involves avoiding alcohol and smoking.\n" +
                    "\n" +
                    "A special advice is not to miss the opportunity for energy work on the 1st lunar day. Wishes made on this day carry particular strength for individuals with a strong connection to the Moon."
        )
    )

val SampleItems: List<SelfKnowledgeItem>
    get() = listOf(
        SelfKnowledgeItem(
            titleResId = R.string.selfknowledge_item_1_title,
            iconId = R.drawable.ic_selfknowledge_item_1,
            detailsIconId = R.drawable.ic_selfknowledge_item_1_details,
            colorResId = R.color.bg_selfknowledge_item_1,
            dividerColorResId = R.color.divider_selfknowledge_item_1,
            generalText = "1th Moon Day",
            secondaryText = "May 11, 1994",
            content = SampleContent,
            previewText = "People born on the 1st lunar day possess an exceptionally strong power of thought. You are emotional, have abundant internal energy, and often tend to be long-lived. People like you are frequently sensitive to natural cycles and are characterized by determination, humility, and kindness. Despite your years, you often appear youthful, and your behavior may have a playful touch. As optimists and cheerful individuals, you must avoid being reclusive or overly modest.",
            points = listOf(
                SelfKnowledgeItemPoint(
                    iconId = R.drawable.ic_strengths,
                    titleResId = R.string.strengths,
                    text = "Power of thought"
                ),

                SelfKnowledgeItemPoint(
                    iconId = R.drawable.ic_weaknesses,
                    titleResId = R.string.weaknesses,
                    text = "Gossip"
                ),
            )
        ),

        SelfKnowledgeItem(
            titleResId = R.string.selfknowledge_item_2_title,
            iconId = R.drawable.ic_selfknowledge_item_2,
            detailsIconId = R.drawable.ic_selfknowledge_item_2_details,
            colorResId = R.color.bg_selfknowledge_item_2,
            dividerColorResId = R.color.divider_selfknowledge_item_2,
            generalText = "Moon in Taurus",
            secondaryText = "May 11, 1994",
            content = SampleContent,
            previewText = "People born on the 1st lunar day possess an exceptionally strong power of thought. You are emotional, have abundant internal energy, and often tend to be long-lived. People like you are frequently sensitive to natural cycles and are characterized by determination, humility, and kindness. Despite your years, you often appear youthful, and your behavior may have a playful touch. As optimists and cheerful individuals, you must avoid being reclusive or overly modest.",
            points = listOf(
                SelfKnowledgeItemPoint(
                    iconId = R.drawable.ic_key_characteristics,
                    titleResId = R.string.key_characteristics,
                    text = "Care, kindness, family"
                ),

                SelfKnowledgeItemPoint(
                    iconId = R.drawable.ic_weaknesses_bed,
                    titleResId = R.string.weaknesses,
                    text = "Gossip"
                ),
            )
        ),

        SelfKnowledgeItem(
            titleResId = R.string.selfknowledge_item_3_title,
            iconId = R.drawable.ic_selfknowledge_item_3,
            detailsIconId = R.drawable.ic_selfknowledge_item_3_details,
            colorResId = R.color.bg_selfknowledge_item_3,
            dividerColorResId = R.color.divider_selfknowledge_item_3,
            generalText = "Waning Crescent",
            secondaryText = "May 11, 1994",
            content = SampleContent,
            previewText = "People born on the 1st lunar day possess an exceptionally strong power of thought. You are emotional, have abundant internal energy, and often tend to be long-lived. People like you are frequently sensitive to natural cycles and are characterized by determination, humility, and kindness. Despite your years, you often appear youthful, and your behavior may have a playful touch. As optimists and cheerful individuals, you must avoid being reclusive or overly modest.",
            points = listOf(
                SelfKnowledgeItemPoint(
                    iconId = R.drawable.ic_key_characteristics,
                    titleResId = R.string.key_characteristics,
                    text = "Power of thought"
                ),

                SelfKnowledgeItemPoint(
                    iconId = R.drawable.ic_weaknesses_bed,
                    titleResId = R.string.weaknesses,
                    text = "Gossip"
                ),
            )
        ),

        SelfKnowledgeItem(
            titleResId = R.string.selfknowledge_item_4_title,
            iconId = R.drawable.ic_selfknowledge_item_4,
            detailsIconId = R.drawable.ic_selfknowledge_item_4_details,
            colorResId = R.color.bg_selfknowledge_item_4,
            dividerColorResId = R.color.divider_selfknowledge_item_4,
            generalText = "Number 3",
            secondaryText = "May 11, 1994",
            content = SampleContent,
            previewText = "People born on the 1st lunar day possess an exceptionally strong power of thought. You are emotional, have abundant internal energy, and often tend to be long-lived. People like you are frequently sensitive to natural cycles and are characterized by determination, humility, and kindness. Despite your years, you often appear youthful, and your behavior may have a playful touch. As optimists and cheerful individuals, you must avoid being reclusive or overly modest.",
            points = listOf(
                SelfKnowledgeItemPoint(
                    iconId = R.drawable.ic_key_characteristics,
                    titleResId = R.string.key_characteristics,
                    text = "Ambition & leadership"
                ),

                SelfKnowledgeItemPoint(
                    iconId = R.drawable.ic_weaknesses,
                    titleResId = R.string.weaknesses,
                    text = "Dictatorship"
                ),
            )
        ),
    )