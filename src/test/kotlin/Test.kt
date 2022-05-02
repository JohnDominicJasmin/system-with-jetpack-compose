
import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.Test


class Test {
    @Test
    fun test() {
        print(getAge("2/3/2022") < 0)
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