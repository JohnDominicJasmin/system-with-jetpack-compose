package resident_feature.domain.util

import resident_feature.common.Constants.NUMBER_OF_CHARACTERS_CONTACT_NUMBER
import resident_feature.common.Constants.REGEX_NUMBER_VALUE
import resident_feature.common.Constants.REGEX_SPECIAL_CHARACTERS_VALUE
import resident_feature.common.Constants.USER_INPUT_MINIMUM_NUMBER_OF_CHARACTERS
import resident_feature.domain.exceptions.ResidentsAuthentication
import resident_feature.domain.model.Resident
import java.text.SimpleDateFormat
import java.util.regex.Pattern

 fun containsNumeric(input: String): Boolean {
    return Pattern.compile(REGEX_NUMBER_VALUE).matcher(input).find()
}
 fun containSpecialCharacters(input: String): Boolean {
    return Pattern.compile(REGEX_SPECIAL_CHARACTERS_VALUE).matcher(input).find()
}
 fun isNumberOfCharactersEnough(input:String, numberOfCharacters: Int = USER_INPUT_MINIMUM_NUMBER_OF_CHARACTERS) =
    input.toCharArray().size >= numberOfCharacters

fun isContactNumberValid(input:String): Boolean =
    input.toCharArray().size == NUMBER_OF_CHARACTERS_CONTACT_NUMBER

fun isDateFormatValid(input: String): Boolean {
    val formatString = "dd/MM/yyyy"

    return runCatching {
        val format = SimpleDateFormat(formatString)
        format.isLenient = false
        format.parse(input)
    }.isSuccess

}




suspend fun validateInput(resident: Resident, action: suspend () -> Unit){
    when {
        resident.fullName.isEmpty() -> {
            throw ResidentsAuthentication.FullNameException("Field cannot be left blank.")
        }

        containsNumeric(resident.fullName) || containSpecialCharacters(resident.fullName) -> {
            throw ResidentsAuthentication.FullNameException("Name must not contain Numbers or Special Characters.")
        }

        !isNumberOfCharactersEnough(resident.fullName) -> {
            throw ResidentsAuthentication.FullNameException("Full name is too short.")
        }


        resident.suffix.isEmpty() -> {
            throw ResidentsAuthentication.SuffixException("Field cannot be left blank.")
        }

        resident.sex.isEmpty() -> {
            throw ResidentsAuthentication.SexException("Field cannot be left blank.")
        }








        resident.address.isEmpty() -> {
            throw ResidentsAuthentication.AddressException("Field cannot be left blank.")
        }

        !isNumberOfCharactersEnough(resident.address) -> {
            throw ResidentsAuthentication.AddressException("Address is Invalid.")
        }






        resident.religion.isEmpty() -> {
            throw ResidentsAuthentication.ReligionException("Field cannot be left blank.")
        }

        !isNumberOfCharactersEnough(resident.religion) -> {
            throw ResidentsAuthentication.ReligionException("Religion is Invalid.")
        }

        containsNumeric(resident.religion) || containSpecialCharacters(resident.religion) -> {
            throw ResidentsAuthentication.ReligionException("Religion must not contain Numbers or Special Characters.")
        }


        resident.civilStatus.isEmpty() -> {
            throw ResidentsAuthentication.CivilStatusException("Field cannot be left blank.")
        }




        resident.contactNumber.isEmpty() -> {
            throw ResidentsAuthentication.ContactNumberException("Field cannot be left blank.")
        }

        !isContactNumberValid(resident.contactNumber) -> {
            throw ResidentsAuthentication.ContactNumberException("Contact Number is Invalid.")
        }

        containSpecialCharacters(resident.contactNumber) -> {
            throw ResidentsAuthentication.ContactNumberException("Contact Number must not contain Special Characters.")
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


        resident.voter.isEmpty() -> {
            throw ResidentsAuthentication.VoterException("Field cannot be left blank.")
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

        !isDateFormatValid(resident.dateOfBirth) -> {
            throw ResidentsAuthentication.DateException("Date is Invalid. Format must be 'Date/Month/Year'.")
        }


        resident.seniorCitizen.isEmpty() -> {
            throw ResidentsAuthentication.SeniorCitizenException("Field cannot be left blank.")
        }


        resident.educationalAttainment.isEmpty() -> {
            throw ResidentsAuthentication.EducationalAttainmentException("Field cannot be left blank.")
        }

        containsNumeric(resident.educationalAttainment) || containSpecialCharacters(resident.educationalAttainment) -> {
            throw ResidentsAuthentication.EducationalAttainmentException("Field must not contain Number or Special Characters.")
        }


        resident.imageName.isEmpty() || resident.localImagePath.isEmpty() -> {
            throw ResidentsAuthentication.ProfileImageException("Profile Image cannot be left blank.")
        }


        else -> action()

    }
}