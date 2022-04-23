package resident_feature.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import resident_feature.data.repository.ResidentRepositoryImpl
import resident_feature.domain.model.Resident
import resident_feature.domain.repository.ResidentRepository
import resident_feature.domain.util.OrderColumn

class GetResidentsUseCase(private val residentRepository: ResidentRepository = ResidentRepositoryImpl()) {
    operator fun invoke(input: OrderColumn): Flow<List<Resident>> {

        return residentRepository.getResidents().map { place ->

            when(input){
                is OrderColumn.FullNameColumn.Ascending -> place.sortedBy { it.fullName }
                is OrderColumn.FullNameColumn.Descending -> place.sortedByDescending { it.fullName }

                is OrderColumn.AgeColumn.Ascending -> place.sortedBy { it.age }
                is OrderColumn.AgeColumn.Descending -> place.sortedByDescending { it.age }

                is OrderColumn.PurokColumn.Ascending -> place.sortedBy { it.purok }
                is OrderColumn.PurokColumn.Descending -> place.sortedByDescending { it.purok }

                is OrderColumn.SexColumn.Ascending -> place.sortedBy { it.sex }
                is OrderColumn.SexColumn.Descending -> place.sortedByDescending { it.sex }

                is OrderColumn.VoterColumn.Ascending -> place.sortedBy { it.voter }
                is OrderColumn.VoterColumn.Descending -> place.sortedByDescending { it.voter }
            }
        }
    }
}