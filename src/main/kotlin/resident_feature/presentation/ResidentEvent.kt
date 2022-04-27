package resident_feature.presentation

import androidx.compose.ui.text.input.TextFieldValue
import resident_feature.domain.model.Resident
import resident_feature.domain.util.OrderType

sealed class ResidentEvent{
    object ResetResident: ResidentEvent()
    data class EnteredSearchValue(val searchQuery: TextFieldValue): ResidentEvent()
    data class SearchResident(val searchQuery: TextFieldValue): ResidentEvent()
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
    data class ItemSelectedSeniorCitizen(val seniorCitizen: String): ResidentEvent()
    data class EnteredCollege(val college: TextFieldValue): ResidentEvent()
    object BrowseImage: ResidentEvent()
    object UpdateResident: ResidentEvent()
    object SaveResident: ResidentEvent()
    data class EditResident(val resident: Resident): ResidentEvent()
    data class DeleteResident(val residentId: Int): ResidentEvent()
    data class SelectResidentRow(val resident: Resident): ResidentEvent()
    data class SortFullName(val orderType : OrderType.FullNameColumnOrder): ResidentEvent()
    data class ToggleSex(val orderType: OrderType.SexColumnOrder): ResidentEvent()
    data class SortAge(val orderType: OrderType.AgeColumnOrder): ResidentEvent()
    data class SortPurok(val orderType: OrderType.PurokColumnOrder): ResidentEvent()
    data class ToggleVoter(val orderType: OrderType.VoterColumnOrder): ResidentEvent()

}
