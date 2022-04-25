package resident_feature.presentation

sealed class ResidentEventResult {
    data class ShowAlertDialog(
        val title: String = "",
        val description: String = "",
        val imageResource: String = ""
    ):ResidentEventResult()
}
