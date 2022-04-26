package resident_feature.presentation

import androidx.compose.ui.text.input.TextFieldValue
import java.io.File

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
    var educationAttainment : TextFieldValue = TextFieldValue(""),
    var educationalAttainmentErrorMessage: String = "",
    var suffix : String = "",
    var sex : String = "",
    var civilStatus : String = "",
    var voter : String = "",
    var seniorCitizen : String = "",

    var isUpdateButtonEnable : Boolean = false,
    var isSaveButtonEnable : Boolean = true,
    var imageFile:File? = null,

    var isFullNameSorted: Boolean = false,
    var isSexToggled: Boolean = false,
    var isAgeSorted: Boolean = false,
    var isPurokSorted: Boolean = false,
    var isVoterToggle: Boolean = false,
    var isLoading: Boolean = false
)
