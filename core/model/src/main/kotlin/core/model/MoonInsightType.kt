package core.model

enum class MoonInsightType {

    MoonDay,
    MoonSign,
    MoonPhase;

    companion object {
        fun MoonInsightType.nextStep(): MoonInsightType? = when (this) {
            MoonDay -> MoonSign
            MoonSign -> MoonPhase
            MoonPhase -> null
        }
    }
}