package resident_feature.domain.use_case

import resident_feature.data.repository.ResidentRepositoryImpl
import resident_feature.domain.model.Resident
import resident_feature.domain.repository.ResidentRepository
import resident_feature.domain.util.validateInput

class UpdateResidentUseCase(private val residentRepository: ResidentRepository = ResidentRepositoryImpl()) {

    suspend operator fun invoke(resident: Resident){
        validateInput(
            resident = resident,
            action = {
                residentRepository.updateResident(resident)
            })

    }
}