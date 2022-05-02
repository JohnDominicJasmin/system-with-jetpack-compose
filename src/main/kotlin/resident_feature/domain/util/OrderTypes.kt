package resident_feature.domain.util


sealed class OrderTypes(){
    data class FullNameColumnOrder(val orderType: OrderType):OrderTypes()
    data class SexColumnOrder(val orderType: OrderType): OrderTypes()
    data class AgeColumnOrder(val orderType: OrderType): OrderTypes()
    data class PurokColumnOrder(val orderType: OrderType): OrderTypes()
    data class VoterColumnOrder(val orderType: OrderType): OrderTypes()
    }

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}