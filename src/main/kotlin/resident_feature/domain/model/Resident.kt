package resident_feature.domain.model

data class Resident(
    val id: String,
    val fullName: String,
    val sex: String ,
    val suffix: String ,
    val address: String,
    val religion: String,
    val age: String,
    val contactNumber: String,
    val purok: String,
    val civilStatus: String,
    val occupation: String,
    val voter: String,
    val citizenship: String,
    val dateOfBirth: String,
    val seniorCitizen: String,
    val educationalAttainment: String,
    val imageName: String,
    val localImagePath: String
    )