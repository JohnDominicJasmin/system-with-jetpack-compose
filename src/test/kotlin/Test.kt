
import kotlinx.coroutines.runBlocking
import resident_feature.domain.model.Resident
import resident_feature.domain.util.validateInput
import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.Test


class Test {
    @Test
    fun test() {
        runBlocking {
            validateInput(
                resident = Resident(
                    fullName = "Jose",
                    sex = "male",
                    suffix = "Jr",
                    address = "Manila",
                    religion = "Muslim",
                    dateOfBirth = "24/09/2001",
                    contactNumber = "09194341361",
                    purok = "Purok Wan",
                    civilStatus = "Single",
                    occupation = "Ninja",
                    voter = "Yes",
                    citizenship = "Peenoise",
                    seniorCitizen = "Yes",
                    educationalAttainment = "College",
                    imageName = "George",
                    localImagePath = "sample_path_to_heaven",
                    age = getAge(dobString = "24/09/2001").toString()
                )
            ) {
                print("Success\n\n")
                print("Age is ${getAge(dobString = "24/09/2001")}")
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