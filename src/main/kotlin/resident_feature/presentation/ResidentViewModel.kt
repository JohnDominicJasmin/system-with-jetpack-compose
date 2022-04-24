package resident_feature.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import resident_feature.domain.use_case.ResidentUseCase

class ResidentViewModel(private val residentsUseCase: ResidentUseCase = ResidentUseCase()) {

    private val _state: MutableState<ResidentInputState> = mutableStateOf(ResidentInputState())
    val state: State<ResidentInputState> = _state

    private val _eventFlow: MutableSharedFlow<ResidentEvent> = MutableSharedFlow()
    val eventFlow: SharedFlow<ResidentEvent> = _eventFlow.asSharedFlow()


    fun onEvent(event: ResidentEvent) {
        when (event) {
            is ResidentEvent.ResetResident -> {
                _state.value = state.value.copy()
            }
            is ResidentEvent.EnteredSearchValue -> {
                _state.value = state.value.copy(searchQuery = event.searchQuery)
            }
            is ResidentEvent.SearchResident -> {
                CoroutineScope(Dispatchers.Default).launch {
                    //TODO ADD SEARCH USE CASE
                }
            }
            is ResidentEvent.EnteredFullName -> {
                _state.value = state.value.copy(fullName =  event.fullName)
            }
            is ResidentEvent.ItemSelectedSuffix -> {
                _state.value = state.value.copy(suffixItemIndex = event.index)
            }
            is ResidentEvent.ItemSelectedSex -> {
                _state.value = state.value.copy(sexItemIndex = event.index)
            }
            is ResidentEvent.EnteredAddress -> {
                _state.value = state.value.copy(address = event.address)
            }
            is ResidentEvent.EnteredReligion -> {
                _state.value = state.value.copy(religion = event.religion)
            }
            is ResidentEvent.ItemSelectedCivilStatus -> {
                _state.value = state.value.copy(civilStatusItemIndex = event.index)
            }
            is ResidentEvent.EnteredContactNumber -> {
                _state.value = state.value.copy(contactNumber = event.contactNumber)
            }
            is ResidentEvent.EnteredPurok -> {
                _state.value = state.value.copy(purok = event.purok)
            }
            is ResidentEvent.EnteredOccupation -> {
                _state.value = state.value.copy(occupation = event.occupation)
            }
            is ResidentEvent.ItemSelectedVoter -> {
                _state.value = state.value.copy(voterItemIndex = event.index)
            }
            is ResidentEvent.EnteredCitizenship -> {
                _state.value = state.value.copy(citizenship = event.citizenship)
            }
            is ResidentEvent.EnteredBirthdate -> {
                _state.value = state.value.copy(dateOfBirth = event.birthdate)
            }
            is ResidentEvent.ItemSelectedSeniorCitizen -> {
                _state.value = state.value.copy(seniorCitizenItemIndex = event.index)
            }
            is ResidentEvent.EnteredCollege -> {
                _state.value = state.value.copy(college = event.college)
            }
            is ResidentEvent.BrowseImage -> {
                CoroutineScope(Dispatchers.Default).launch {
                    residentsUseCase
                }
            }
            is ResidentEvent.UpdateResident -> {
                CoroutineScope(Dispatchers.Default).launch {
                }
            }
            is ResidentEvent.SaveResident -> {
                CoroutineScope(Dispatchers.Default).launch {
                }
            }
        }

    }


}