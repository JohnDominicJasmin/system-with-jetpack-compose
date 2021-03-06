package resident_feature.presentation

import androidx.compose.ui.text.input.TextFieldValue
import resident_feature.domain.model.Resident
import resident_feature.domain.util.OrderTypes

sealed class ResidentEvent{
    object ResetResident: ResidentEvent()
    data class EnteredSearchValue(val searchQuery: TextFieldValue): ResidentEvent()
    object SearchResident: ResidentEvent()
    data class EnteredFullName(val fullName: TextFieldValue): ResidentEvent()
    data class SelectedSuffix(val suffix: String): ResidentEvent()
    data class SelectedSex(val sex: String): ResidentEvent()
    data class EnteredAddress(val address: TextFieldValue): ResidentEvent()
    data class EnteredReligion(val religion: TextFieldValue): ResidentEvent()
    data class SelectedCivilStatus(val civilStatus: String): ResidentEvent()
    data class EnteredContactNumber(val contactNumber: TextFieldValue): ResidentEvent()
    data class EnteredPurok(val purok: TextFieldValue): ResidentEvent()
    data class EnteredOccupation(val occupation: TextFieldValue): ResidentEvent()
    data class SelectedVoter(val voter: String): ResidentEvent()
    data class EnteredCitizenship(val citizenship: TextFieldValue): ResidentEvent()
    data class EnteredBirthdate(val birthdate: TextFieldValue): ResidentEvent()
    data class SelectedSeniorCitizen(val seniorCitizen: String): ResidentEvent()
    data class EnteredEducationalAttainment(val educationalAttainment: TextFieldValue): ResidentEvent()
    object BrowseImage: ResidentEvent()
    object UpdateResident: ResidentEvent()
    object SaveResident: ResidentEvent()
    data class EditResident(val resident: Resident): ResidentEvent()
    data class DeleteResident(val residentId: Int): ResidentEvent()
    data class SelectResidentRow(val resident: Resident): ResidentEvent()

    data class SortFullName(val orderTypes : OrderTypes): ResidentEvent()
    data class ToggleSex(val orderTypes: OrderTypes): ResidentEvent()
    data class SortAge(val orderTypes: OrderTypes): ResidentEvent()
    data class SortPurok(val orderTypes: OrderTypes): ResidentEvent()
    data class ToggleVoter(val orderTypes: OrderTypes): ResidentEvent()

}
