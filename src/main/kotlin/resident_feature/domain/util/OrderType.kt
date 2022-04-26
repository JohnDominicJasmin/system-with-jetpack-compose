package resident_feature.domain.util


sealed class OrderType{
    sealed class FullNameColumnOrder: OrderType(){
        object Ascending: FullNameColumnOrder()
        object Descending: FullNameColumnOrder()
    }

    sealed class SexColumnOrder: OrderType(){
        object Ascending: SexColumnOrder()
        object Descending: SexColumnOrder()
    }

    sealed class AgeColumnOrder: OrderType(){
        object Ascending: AgeColumnOrder()
        object Descending: AgeColumnOrder()
    }

    sealed class PurokColumnOrder: OrderType(){
        object Ascending: PurokColumnOrder()
        object Descending: PurokColumnOrder()
    }


    sealed class VoterColumnOrder: OrderType(){
        object Ascending: VoterColumnOrder()
        object Descending: VoterColumnOrder()
    }

    }