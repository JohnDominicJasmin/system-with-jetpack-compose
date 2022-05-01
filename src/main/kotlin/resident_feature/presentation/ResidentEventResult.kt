package resident_feature.presentation

sealed class ResidentEventResult {
    data class ShowAlertDialog(
        val alertDialogType: AlertDialogType,
        val title: String = "",
        val description: String = "",
    ):ResidentEventResult()
}
sealed class AlertDialogType{
    object SuccessDialog: AlertDialogType()
    object ErrorDialog: AlertDialogType()
    object WarningDialog: AlertDialogType()
}
