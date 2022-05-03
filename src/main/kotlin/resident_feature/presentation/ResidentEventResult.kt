package resident_feature.presentation

sealed class ResidentEventResult {
    data class SuccessDialog(
        val title: String = "",
        val description: String = "",
    ) : ResidentEventResult()

    data class ErrorDialog(
        val title: String = "",
        val description: String = "",
    ) : ResidentEventResult()

    data class WarningDialog(
        val title: String = "",
        val description: String = "",
    ) : ResidentEventResult()

}

 