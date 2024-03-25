package activity.model

import com.moonila.activity.R

enum class MenuItem(
    val iconResId: Int,
    val activeIconResId: Int,
    val labelResId: Int,
    val colorResId: Int
) {

    Calendar(
        iconResId = R.drawable.ic_menu_calendar,
        activeIconResId = R.drawable.ic_menu_calendar_active,
        labelResId = R.string.menu_item_calendar,
        colorResId = R.color.menu_item_calendar_color
    ),

    Compatibility(
        iconResId = R.drawable.ic_menu_compatibility,
        activeIconResId = R.drawable.ic_menu_compatibility_active,
        labelResId = R.string.menu_item_compatibility,
        colorResId = R.color.menu_item_compatibility_color
    ),

    Knowledge(
        iconResId = R.drawable.ic_menu_knowledge,
        activeIconResId = R.drawable.ic_menu_knowledge_active,
        labelResId = R.string.menu_item_knowledge,
        colorResId = R.color.menu_item_knowledge_color
    ),

    Practice(
        iconResId = R.drawable.ic_menu_practice,
        activeIconResId = R.drawable.ic_menu_practice_active,
        labelResId = R.string.menu_item_practice,
        colorResId = R.color.menu_item_practice_color
    ),

    Wisdom(
        iconResId = R.drawable.ic_menu_wisdom,
        activeIconResId = R.drawable.ic_menu_wisdom_active,
        labelResId = R.string.menu_item_wisdom,
        colorResId = R.color.menu_item_wisdom_color
    ),

}