package resident_feature.domain.util


sealed class OrderColumn{
    sealed class FullNameColumn: OrderColumn(){
        object Ascending: FullNameColumn()
        object Descending: FullNameColumn()
    }

    sealed class SexColumn: OrderColumn(){
        object Ascending: SexColumn()
        object Descending: SexColumn()
    }

    sealed class AgeColumn: OrderColumn(){
        object Ascending: AgeColumn()
        object Descending: AgeColumn()
    }

    sealed class PurokColumn: OrderColumn(){
        object Ascending: PurokColumn()
        object Descending: PurokColumn()
    }


    sealed class VoterColumn: OrderColumn(){
        object Ascending: VoterColumn()
        object Descending: VoterColumn()
    }

}