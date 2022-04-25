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
import resident_feature.domain.exceptions.ResidentsAuthentication
import resident_feature.domain.model.Resident
import resident_feature.domain.use_case.ResidentUseCase
import java.text.SimpleDateFormat
import java.util.*

class ResidentViewModel(private val residentsUseCase: ResidentUseCase = ResidentUseCase()) {

    private val _state: MutableState<ResidentInputState> = mutableStateOf(ResidentInputState())
    val state: State<ResidentInputState> = _state

    private val _eventFlow: MutableSharedFlow<ResidentEventResult> = MutableSharedFlow()
    val eventFlow: SharedFlow<ResidentEventResult> = _eventFlow.asSharedFlow()


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
                _state.value = state.value.copy(fullName = event.fullName)
            }
            is ResidentEvent.SelectedSuffix -> {
                _state.value = state.value.copy(suffix = event.suffix)
            }
            is ResidentEvent.SelectedSex -> {
                _state.value = state.value.copy(sex = event.sex)
            }
            is ResidentEvent.EnteredAddress -> {
                _state.value = state.value.copy(address = event.address)
            }
            is ResidentEvent.EnteredReligion -> {
                _state.value = state.value.copy(religion = event.religion)
            }
            is ResidentEvent.SelectedCivilStatus -> {
                _state.value = state.value.copy(civilStatus = event.civilStatus)
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
            is ResidentEvent.SelectedVoter -> {
                _state.value = state.value.copy(voter = event.voter)
            }
            is ResidentEvent.EnteredCitizenship -> {
                _state.value = state.value.copy(citizenship = event.citizenship)
            }
            is ResidentEvent.EnteredBirthdate -> {
                _state.value = state.value.copy(dateOfBirth = event.birthdate)
            }
            is ResidentEvent.ItemSelectedSeniorCitizen -> {
                _state.value = state.value.copy(seniorCitizen = event.seniorCitizen)
            }
            is ResidentEvent.EnteredCollege -> {
                _state.value = state.value.copy(educationAttainment = event.college)
            }
            is ResidentEvent.BrowseImage -> {
                CoroutineScope(Dispatchers.Default).launch {
                    residentsUseCase.openFileUseCase { file ->
                        _state.value = state.value.copy(imageFile = file)
                    }
                }
            }
            is ResidentEvent.UpdateResident -> {
                CoroutineScope(Dispatchers.Default).launch {
                    with(state.value) {
                        manipulateData(successMessage = "Resident Successfully Updated!", onManipulation =  {
                            residentsUseCase.updateResidentUseCase(
                                resident = Resident(
                                    fullName = fullName.text,
                                    sex = sex,
                                    suffix = suffix,
                                    address = address.text,
                                    religion = religion.text,
                                    dateOfBirth = dateOfBirth.text,
                                    age = getAge(dateOfBirth.text).toString(),
                                    contactNumber = contactNumber.text,
                                    purok = purok.text,
                                    civilStatus = civilStatus,
                                    occupation = occupation.text,
                                    voter = voter,
                                    citizenship = citizenship.text,
                                    seniorCitizen = seniorCitizen,
                                    educationalAttainment = educationAttainment.text,
                                    imageName = imageFile!!.nameWithoutExtension,
                                    localImagePath = imageFile!!.canonicalPath
                                )
                            )
                        })

                    }
                }
            }
            is ResidentEvent.SaveResident -> {

                with(state.value) {
                    CoroutineScope(Dispatchers.Default).launch {
                        manipulateData(successMessage = "Resident Successfully Added!", onManipulation = {
                            residentsUseCase.addResidentUseCase(
                                resident = Resident(
                                    fullName = fullName.text,
                                    sex = sex,
                                    suffix = suffix,
                                    address = address.text,
                                    religion = religion.text,
                                    dateOfBirth = dateOfBirth.text,
                                    age = getAge(dateOfBirth.text).toString(),
                                    contactNumber = contactNumber.text,
                                    purok = purok.text,
                                    civilStatus = civilStatus,
                                    occupation = occupation.text,
                                    voter = voter,
                                    citizenship = citizenship.text,
                                    seniorCitizen = seniorCitizen,
                                    educationalAttainment = educationAttainment.text,
                                    imageName = imageFile!!.nameWithoutExtension,
                                    localImagePath = imageFile!!.canonicalPath
                                )
                            )
                        })
                    }
                }
            }

            is ResidentEvent.EditResident -> {

            }
            is ResidentEvent.DeleteResident -> {
                kotlin.runCatching {
                }
            }
        }

    }

    private suspend fun manipulateData(onManipulation: suspend () -> Unit, successMessage: String){
        kotlin.runCatching {
            onManipulation()
        }.onSuccess {
            state.value.imageFile?.let { file ->
                residentsUseCase.saveImageToLocalFolderUseCase(file = file)
            }.also {
                _eventFlow.emit(
                    value = ResidentEventResult.ShowAlertDialog(
                        title = "Success",
                        description = successMessage,
                        imageResource = ""
                    )
                )
            }
        }.onFailure { exception ->
            when (exception) {
                is ResidentsAuthentication.ResidentsManipulationException -> {
                    _eventFlow.emit(
                        ResidentEventResult.ShowAlertDialog(
                            title = "Error",
                            description = exception.message
                                ?: "Unfortunately error occurred, please try again.",
                            imageResource = ""
                        )
                    )

                }
                }
        }
    }
    private fun getAge(dobString: String): Int {
        var date: Date? = null
        val sdf = SimpleDateFormat("dd/MM/yyyy")

        kotlin.runCatching {
            date = sdf.parse(dobString)
        }.onFailure { print("Failed") }


        if (date == null) return 0
        val dob = Calendar.getInstance()
        val today = Calendar.getInstance()
        dob.time = date
        val year = dob[Calendar.YEAR]
        val month = dob[Calendar.MONTH]
        val day = dob[Calendar.DAY_OF_MONTH]
        dob[year, month + 1] = day
        var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
        if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
            age--
        }
        return age
    }

}