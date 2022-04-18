package resident_feature.presentation

data class TableRowState(
    val fullName: String,
    val sex: Sex,
    val age: Int,
    val purok: String,
    val civilStatus: CivilStatus,
    val occupation: String,
    val voter: Voter,
    val address: String
)


sealed class CivilStatus{
    object Single: CivilStatus()
    object Married: CivilStatus()
    object Widowed: CivilStatus()
    object Divorced: CivilStatus()
}

sealed class Voter{
    object Yes: Voter()
    object No: Voter()
}

sealed class Sex{
    object Male: Sex()
    object Female: Sex()
}