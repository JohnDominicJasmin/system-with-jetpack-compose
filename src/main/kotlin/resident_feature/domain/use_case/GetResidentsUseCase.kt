package resident_feature.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import resident_feature.data.repository.ResidentRepositoryImpl
import resident_feature.domain.model.Resident
import resident_feature.domain.repository.ResidentRepository
import resident_feature.domain.util.OrderType
import resident_feature.domain.util.OrderTypes

class GetResidentsUseCase(private val residentRepository: ResidentRepository = ResidentRepositoryImpl()) {
    operator fun invoke(input: OrderTypes): Flow<List<Resident>> {

        return residentRepository.getResidents().map { resident ->

            when (input) {
                is OrderTypes.FullNameColumnOrder -> {
                    if (input.orderType == OrderType.Ascending) {
                        resident.sortedBy { it.fullName }
                    } else {
                        resident.sortedByDescending { it.fullName }
                    }

                }


                is OrderTypes.AgeColumnOrder -> {
                    if (input.orderType == OrderType.Ascending) {
                        resident.sortedBy { it.age }
                    } else {
                        resident.sortedByDescending { it.age }
                    }
                }


                is OrderTypes.SexColumnOrder -> {
                    if (input.orderType == OrderType.Ascending) {
                        resident.sortedBy { it.sex }
                    } else {
                        resident.sortedByDescending { it.sex }
                    }
                }

                is OrderTypes.PurokColumnOrder -> {
                    if (input.orderType == OrderType.Ascending) {
                        resident.sortedBy { it.purok }
                    } else {
                        resident.sortedByDescending { it.purok }
                    }
                }

                is OrderTypes.VoterColumnOrder -> {
                    if (input.orderType == OrderType.Ascending) {
                        resident.sortedBy { it.voter }
                    } else {
                        resident.sortedByDescending { it.voter }
                    }
                }


            }

        }
    }
}
