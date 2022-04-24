package resident_feature.presentation

import androidx.compose.ui.text.input.TextFieldValue

data class ResidentInputState(
    var fullName: TextFieldValue = TextFieldValue(""),
    var fullNameErrorMessage: String = "",
    var address : TextFieldValue = TextFieldValue(""),
    var addressErrorMessage : String = "",
    var religion : TextFieldValue = TextFieldValue(""),
    var religionErrorMessage : String = "",
    var contactNumber : TextFieldValue = TextFieldValue(""),
    var contactNumberErrorMessage: String = "",
    var purok : TextFieldValue = TextFieldValue(""),
    var purokErrorMessage: String = "",
    var occupation : TextFieldValue = TextFieldValue(""),
    var occupationErrorMessage: String = "",
    var citizenship : TextFieldValue = TextFieldValue(""),
    var citizenshipErrorMessage: String = "",
    var dateOfBirth : TextFieldValue = TextFieldValue(""),
    var dateErrorMessage: String = "",
    var college : TextFieldValue = TextFieldValue(""),
    var collegeErrorMessage: String = "",
    var isLoading: Boolean = false
)
