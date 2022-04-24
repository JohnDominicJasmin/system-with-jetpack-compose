package resident_feature.presentation

import androidx.compose.ui.text.input.TextFieldValue

sealed class ResidentEvent{
    object ResetResident: ResidentEvent()
    data class EnteredSearchValue(val searchQuery: TextFieldValue): ResidentEvent()
    object SearchResident: ResidentEvent()
    data class EnteredFullName(val fullName: TextFieldValue): ResidentEvent()
    data class ItemSelectedSuffix(val index: Int): ResidentEvent()
    data class ItemSelectedSex(val index: Int): ResidentEvent()
    data class EnteredAddress(val address: TextFieldValue): ResidentEvent()
    data class EnteredReligion(val religion: TextFieldValue): ResidentEvent()
    data class ItemSelectedCivilStatus(val index: Int): ResidentEvent()
    data class EnteredContactNumber(val contactNumber: TextFieldValue): ResidentEvent()
    data class EnteredPurok(val purok: TextFieldValue): ResidentEvent()
    data class EnteredOccupation(val occupation: TextFieldValue): ResidentEvent()
    data class ItemSelectedVoter(val index: Int): ResidentEvent()
    data class EnteredCitizenship(val citizenship: TextFieldValue): ResidentEvent()
    data class EnteredBirthdate(val birthdate: TextFieldValue): ResidentEvent()
    data class ItemSelectedSeniorCitizen(val index: Int): ResidentEvent()
    data class EnteredCollege(val college: TextFieldValue): ResidentEvent()
    object BrowseImage: ResidentEvent()
    object UpdateResident: ResidentEvent()
    object SaveResident: ResidentEvent()

}
