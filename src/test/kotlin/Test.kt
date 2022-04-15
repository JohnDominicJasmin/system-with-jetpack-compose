
import java.text.SimpleDateFormat
import kotlin.test.Test

class Test {
    @Test
    fun test() {
        println(assert( isValidDate("45/23/234")))
        println(assert(isValidDate("12/12/2111")))
    }

    private fun isValidDate(input: String): Boolean {
        val formatString = "MM/dd/yyyy"

        return kotlin.runCatching {
            val format = SimpleDateFormat(formatString)
            format.isLenient = false
            format.parse(input)
        }.isSuccess


    }

}