package resident_feature.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import resident_feature.data.repository.ResidentRepositoryImpl
import resident_feature.domain.model.Resident
import resident_feature.domain.repository.ResidentRepository
import resident_feature.domain.util.OrderType

class GetResidentsUseCase(private val residentRepository: ResidentRepository = ResidentRepositoryImpl()) {
    operator fun invoke(input: OrderType): Flow<List<Resident>> {

        return residentRepository.getResidents().map { place ->

            when(input){
                is OrderType.FullNameColumnOrder.Ascending -> place.sortedBy { it.fullName }
                is OrderType.FullNameColumnOrder.Descending -> place.sortedByDescending { it.fullName }

                is OrderType.AgeColumnOrder.Ascending -> place.sortedBy { it.age }
                is OrderType.AgeColumnOrder.Descending -> place.sortedByDescending { it.age }

                is OrderType.PurokColumnOrder.Ascending -> place.sortedBy { it.purok }
                is OrderType.PurokColumnOrder.Descending -> place.sortedByDescending { it.purok }

                is OrderType.SexColumnOrder.Ascending -> place.sortedBy { it.sex }
                is OrderType.SexColumnOrder.Descending -> place.sortedByDescending { it.sex }

                is OrderType.VoterColumnOrder.Ascending -> place.sortedBy { it.voter }
                is OrderType.VoterColumnOrder.Descending -> place.sortedByDescending { it.voter }
            }
        }
    }
}