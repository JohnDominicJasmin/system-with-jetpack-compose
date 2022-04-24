package resident_feature.presentation

import androidx.compose.ui.text.input.TextFieldValue

data class ResidentInputState(
    var searchQuery: TextFieldValue = TextFieldValue(""),
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
    var suffixItemIndex : Int = 0,
    var sexItemIndex : Int = 0,
    var civilStatusItemIndex : Int = 0,
    var voterItemIndex : Int = 0,
    var seniorCitizenItemIndex : Int = 0,
    var isUpdateButtonEnable : Boolean = false,
    var isSaveButtonEnable : Boolean = true,
    var isLoading: Boolean = false
)
