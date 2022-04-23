package resident_feature.domain.use_case

import resident_feature.common.Constants.NUMBER_OF_CHARACTERS_CONTACT_NUMBER
import resident_feature.data.repository.ResidentRepositoryImpl
import resident_feature.domain.exceptions.ResidentsAuthentication
import resident_feature.domain.model.Resident
import resident_feature.domain.repository.ResidentRepository
import resident_feature.domain.util.containSpecialCharacters
import resident_feature.domain.util.containsNumeric
import resident_feature.domain.util.isNumberOfCharactersShort
import resident_feature.domain.util.isValidDate

class AddResidentUseCase(private val residentRepository: ResidentRepository = ResidentRepositoryImpl()) {



    suspend operator fun invoke(resident: Resident){

    //todo: edit error message later.
        return when {



            resident.fullName.isEmpty() -> {
                throw ResidentsAuthentication.FullNameException("Field cannot be left blank.")
            }

            containsNumeric(resident.fullName) || containSpecialCharacters(resident.fullName) -> {
                throw ResidentsAuthentication.FullNameException("Name must not contain Numbers or Special Characters.")
            }

            isNumberOfCharactersShort(resident.fullName) -> {
                throw ResidentsAuthentication.FullNameException("Full name is too short.")
            }






            resident.address.isEmpty() -> {
                throw ResidentsAuthentication.AddressException("Field cannot be left blank.")
            }

            isNumberOfCharactersShort(resident.address) -> {
                throw ResidentsAuthentication.AddressException("Address is Invalid.")
            }






            resident.religion.isEmpty() -> {
                throw ResidentsAuthentication.ReligionException("Field cannot be left blank.")
            }

            isNumberOfCharactersShort(resident.religion) -> {
                throw ResidentsAuthentication.ReligionException("Religion is Invalid.")
            }

            containsNumeric(resident.religion) || containSpecialCharacters(resident.religion) -> {
                throw ResidentsAuthentication.ReligionException("Religion must not contain Numbers or Special Characters.")
            }




            resident.contactNumber.isEmpty() -> {
                throw ResidentsAuthentication.ContactNumberException("Field cannot be left blank.")
            }

            isNumberOfCharactersShort(resident.contactNumber, numberOfCharacters = NUMBER_OF_CHARACTERS_CONTACT_NUMBER) -> {
                throw ResidentsAuthentication.ContactNumberException("Contact Number is Invalid.")
            }

            containsNumeric(resident.contactNumber) || containSpecialCharacters(resident.contactNumber) -> {
                throw ResidentsAuthentication.ContactNumberException("Contact Number must not contain Numbers or Special Characters.")
            }



            resident.purok.isEmpty()-> {
                throw ResidentsAuthentication.PurokException("Field cannot be left blank.")
            }





            resident.occupation.isEmpty() -> {
                throw ResidentsAuthentication.OccupationException("Field cannot be left blank.")
            }

            containsNumeric(resident.occupation) || containSpecialCharacters(resident.occupation) -> {
                throw ResidentsAuthentication.OccupationException("Occupation must not contain Numbers or Special Characters.")
            }



            resident.citizenship.isEmpty() -> {
                throw ResidentsAuthentication.CitizenshipException("Field cannot be left blank.")
            }

            containsNumeric(resident.citizenship) || containSpecialCharacters(resident.citizenship) -> {
                throw ResidentsAuthentication.CitizenshipException("Citizenship must not contain Numbers or Special Characters.")
            }



            resident.dateOfBirth.isEmpty() -> {
                throw ResidentsAuthentication.DateException("Field cannot be left blank.")
            }

            !isValidDate(resident.dateOfBirth) -> {
                throw ResidentsAuthentication.DateException("Date is Invalid.")
            }




            resident.educationalAttainment.isEmpty() -> {
                throw ResidentsAuthentication.EducationalAttainmentException("Field cannot be left blank.")
            }

            containsNumeric(resident.educationalAttainment) || containSpecialCharacters(resident.educationalAttainment) -> {
                throw ResidentsAuthentication.EducationalAttainmentException("Field must not contain Number or Special Characters.")
            }

            else -> {
                 residentRepository.addResident(resident)
            }
        }

    }
}