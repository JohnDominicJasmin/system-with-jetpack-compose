package resident_feature.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import resident_feature.domain.exceptions.ResidentsAuthentication
import resident_feature.domain.model.Resident
import resident_feature.domain.use_case.ResidentUseCase
import resident_feature.domain.util.OrderType
import java.text.SimpleDateFormat
import java.util.*

class ResidentViewModel(private val residentsUseCase: ResidentUseCase = ResidentUseCase()) {

    private val _inputState: MutableState<ResidentInputState> = mutableStateOf(ResidentInputState())
    val inputState: State<ResidentInputState> = _inputState

    private val _tableState: MutableState<ResidentTableState> = mutableStateOf(ResidentTableState())
    val tableState: State<ResidentTableState> = _tableState

    private val _eventFlow: MutableSharedFlow<ResidentEventResult> = MutableSharedFlow()
    val eventFlow: SharedFlow<ResidentEventResult> = _eventFlow.asSharedFlow()

    private var job: Job? = null


    init {
        loadResidents(columnOrder = OrderType.FullNameColumnOrder.Ascending)
    }

      fun onEvent(event: ResidentEvent) {

        with(inputState.value) {
            when (event) {
                is ResidentEvent.ResetResident -> {
                    _inputState.value = ResidentInputState()
                }
                is ResidentEvent.EnteredSearchValue -> {
                    _inputState.value = this.copy(searchQuery = event.searchQuery)
                }
                is ResidentEvent.SearchResident -> {
                    _inputState.value = this.copy(searchQuery = event.searchQuery)
                }
                is ResidentEvent.EnteredFullName -> {
                    _inputState.value = this.copy(fullName = event.fullName)
                }
                is ResidentEvent.SelectedSuffix -> {
                    _inputState.value = this.copy(suffix = event.suffix)
                }
                is ResidentEvent.SelectedSex -> {
                    _inputState.value = this.copy(sex = event.sex)
                }
                is ResidentEvent.EnteredAddress -> {
                    _inputState.value = this.copy(address = event.address)
                }
                is ResidentEvent.EnteredReligion -> {
                    _inputState.value = this.copy(religion = event.religion)
                }
                is ResidentEvent.SelectedCivilStatus -> {
                    _inputState.value = this.copy(civilStatus = event.civilStatus)
                }
                is ResidentEvent.EnteredContactNumber -> {
                    _inputState.value = this.copy(contactNumber = event.contactNumber)
                }
                is ResidentEvent.EnteredPurok -> {
                    _inputState.value = this.copy(purok = event.purok)
                }
                is ResidentEvent.EnteredOccupation -> {
                    _inputState.value = this.copy(occupation = event.occupation)
                }
                is ResidentEvent.SelectedVoter -> {
                    _inputState.value = this.copy(voter = event.voter)
                }
                is ResidentEvent.EnteredCitizenship -> {
                    _inputState.value = this.copy(citizenship = event.citizenship)
                }
                is ResidentEvent.EnteredBirthdate -> {
                    _inputState.value = this.copy(dateOfBirth = event.birthdate)
                }
                is ResidentEvent.SelectedSeniorCitizen -> {
                    _inputState.value = this.copy(seniorCitizen = event.seniorCitizen)
                }
                is ResidentEvent.EnteredEducationalAttainment -> {
                    _inputState.value = this.copy(educationalAttainment = event.educationalAttainment)
                }
                is ResidentEvent.BrowseImage -> {
                    CoroutineScope(Dispatchers.Default).launch {
                        residentsUseCase.openFileUseCase { selectedFile ->
                            _inputState.value =
                                this@with.copy(imagePath = selectedFile.canonicalPath, imageName = selectedFile.name)
                        }
                    }
                }
                is ResidentEvent.UpdateResident -> {
                    CoroutineScope(Dispatchers.Default).launch {
                        manipulateData(successMessage = "Resident Successfully Updated!", onManipulate = {
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
                                    educationalAttainment = educationalAttainment.text,
                                    imageName = imageName,
                                    localImagePath = imagePath,
                                    id = id,
                                )
                            )
                        })
                    }
                }
                is ResidentEvent.SaveResident -> {

                    CoroutineScope(Dispatchers.Default).launch {
                        manipulateData(successMessage = "Resident Successfully Added!", onManipulate = {
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
                                    educationalAttainment = educationalAttainment.text,
                                    imageName = imageName,
                                    localImagePath = imagePath
                                )
                            )
                        })
                    }
                }

                is ResidentEvent.EditResident -> {
                    loadResident(resident = event.resident)
                    _inputState.value = this.copy(isSaveButtonEnable = true, isUpdateButtonEnable = false)
                }
                is ResidentEvent.DeleteResident -> {
                    CoroutineScope(Dispatchers.Default).launch {
                        kotlin.runCatching {
                            //TODO: SHOW YES ON NO DIALOG, NO NEED TO SHOW THIS RESIDENT TO INPUTS
                            residentsUseCase.deleteResidentUseCase(event.residentId)

                        }.onSuccess {
                            _eventFlow.emit(
                                value =
                                ResidentEventResult.ShowAlertDialog(
                                    title = "Success",
                                    description = "Resident Successfully Deleted",
                                    imageResource = ""
                                )
                            )
                        }.onFailure {
                            _eventFlow.emit(
                                value =
                                ResidentEventResult.ShowAlertDialog(
                                    title = "Failed",
                                    description = "Resident Failed to Deleted",
                                    imageResource = ""
                                )
                            )
                        }
                    }
                }
                is ResidentEvent.SelectResidentRow -> {
                    loadResident(resident = event.resident)
                    _inputState.value = this.copy(isSaveButtonEnable = false, isUpdateButtonEnable = false)
                }
                is ResidentEvent.SortFullName -> {
                    loadResidents(columnOrder = event.orderType)
                }
                is ResidentEvent.ToggleSex -> {
                    loadResidents(columnOrder = event.orderType)
                }
                is ResidentEvent.SortAge -> {
                    loadResidents(columnOrder = event.orderType)
                }
                is ResidentEvent.SortPurok -> {
                    loadResidents(columnOrder = event.orderType)
                }
                is ResidentEvent.ToggleVoter -> {
                    loadResidents(columnOrder = event.orderType)
                }

            }
        }
    }

    private fun loadResident(resident: Resident) {
        with(resident) {
            _inputState.value = inputState.value.copy(
                id = resident.id,
                fullName = TextFieldValue(text = resident.fullName),
                suffix = suffix,
                sex = sex,
                address = TextFieldValue(text = resident.address),
                religion = TextFieldValue(text = resident.religion),
                civilStatus = civilStatus,
                contactNumber = TextFieldValue(text = resident.contactNumber),
                purok = TextFieldValue(text = resident.purok),
                occupation = TextFieldValue(text = resident.occupation),
                voter = voter,
                citizenship = TextFieldValue(text = resident.citizenship),
                dateOfBirth = TextFieldValue(text = resident.dateOfBirth),
                seniorCitizen = seniorCitizen,
                educationalAttainment = TextFieldValue(text = resident.educationalAttainment),
                isUpdateButtonEnable = true,
                isSaveButtonEnable = false,
                imagePath = resident.localImagePath,
                imageName = resident.imageName,
                isLoading = false,
            )
        }
    }

    private fun loadResidents(columnOrder: OrderType) {

        job?.cancel()
        job = CoroutineScope(Dispatchers.Default).launch {
            residentsUseCase.getResidentsUseCase(columnOrder).onEach { residents ->
                _tableState.value = tableState.value.copy(residents = residents, columnOrder = columnOrder)
            }
        }
    }

    private suspend fun manipulateData(successMessage: String, onManipulate: suspend () -> Unit) {

        with(inputState.value) {
            kotlin.runCatching {
                _inputState.value = this@with.copy(isLoading = true)
                onManipulate()
            }.onSuccess {
                _inputState.value = this@with.copy(isLoading = false)
                residentsUseCase.saveImageToLocalFolderUseCase(
                    filePath = inputState.value.imagePath, fileName = inputState.value.imageName
                ).also {
                    _eventFlow.emit(
                        value = ResidentEventResult.ShowAlertDialog(
                            title = "Success",
                            description = successMessage,
                            imageResource = ""
                        )
                    )
                }
            }.onFailure { exception ->
                _inputState.value = this@with.copy(isLoading = false)
                when (exception) {
                    is ResidentsAuthentication.ResidentsManipulationException -> {
                        _eventFlow.emit(
                            ResidentEventResult.ShowAlertDialog(
                                title = "Error",
                                description = exception.message ?: "Unfortunately error occurred, please try again.",
                                imageResource = ""
                            )
                        )
                    }
                    is ResidentsAuthentication.FullNameException -> {
                        _inputState.value =
                            this@with.copy(fullNameErrorMessage = exception.message ?: "Full name is Invalid!")
                    }
                    is ResidentsAuthentication.AddressException -> {
                        _inputState.value =
                            this@with.copy(addressErrorMessage = exception.message ?: "Address is Invalid!")
                    }
                    is ResidentsAuthentication.ReligionException -> {
                        _inputState.value =
                            this@with.copy(religionErrorMessage = exception.message ?: "Religion is Invalid!")
                    }
                    is ResidentsAuthentication.ContactNumberException -> {
                        _inputState.value = this@with.copy(
                            contactNumberErrorMessage = exception.message ?: "Contact Number is Invalid!"
                        )
                    }
                    is ResidentsAuthentication.PurokException -> {
                        _inputState.value = this@with.copy(purokErrorMessage = exception.message ?: "Purok is Invalid!")
                    }
                    is ResidentsAuthentication.OccupationException -> {
                        _inputState.value =
                            this@with.copy(occupationErrorMessage = exception.message ?: "Occupation is Invalid!")
                    }
                    is ResidentsAuthentication.CitizenshipException -> {
                        _inputState.value =
                            this@with.copy(citizenshipErrorMessage = exception.message ?: "Citizenship is Invalid!")
                    }
                    is ResidentsAuthentication.DateException -> {
                        _inputState.value =
                            this@with.copy(dateOfBirthErrorMessage = exception.message ?: "Birthdate is Invalid!")
                    }
                    is ResidentsAuthentication.EducationalAttainmentException -> {
                        _inputState.value = this@with.copy(
                            educationalAttainmentErrorMessage = exception.message
                                ?: "Educational Attainment is Invalid!"
                        )
                    }
                    is ResidentsAuthentication.ProfileImageException -> {
                        _inputState.value =
                            this@with.copy(profileImageErrorMessage = exception.message ?: "Profile Image is Blank")
                    }
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