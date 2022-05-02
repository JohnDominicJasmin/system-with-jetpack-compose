package resident_feature.presentation

import androidx.compose.ui.text.input.TextFieldValue
import resident_feature.domain.util.OrderType
import resident_feature.domain.util.OrderTypes
import resident_feature.util.DrawableResource

data class ResidentInputState(
    var searchQuery: TextFieldValue = TextFieldValue(""), //todo : use this
    var id : Int = -1,

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
    var dateOfBirthErrorMessage: String = "",

    var educationalAttainment : TextFieldValue = TextFieldValue(""),
    var educationalAttainmentErrorMessage: String = "",





    var suffix : String = "",
    var suffixErrorMessage: String = "",

    var sex : String = "",
    var sexErrorMessage: String = "",

    var civilStatus : String = "",
    var civilStatusErrorMessage: String = "",

    var voter : String = "",
    var voterErrorMessage: String = "",

    var seniorCitizen : String = "",
    var seniorCitizenErrorMessage: String = "",

    var orderTypes : OrderTypes = OrderTypes.FullNameColumnOrder(orderType = OrderType.Descending),



    var isUpdateButtonEnable : Boolean = false,//todo : use this
    var isSaveButtonEnable : Boolean = true,//todo : use this

    var imageName :String = DrawableResource.ProfilePlaceHolder.resource,
    var profileImageErrorMessage: String = "",

    var isLoading: Boolean = false
)
