package resident_feature.domain.use_case

import resident_feature.data.repository.ResidentRepositoryImpl
import resident_feature.domain.repository.ResidentRepository
import java.io.File

class OpenFileUseCase(private val residentRepository: ResidentRepository = ResidentRepositoryImpl()) {
    operator fun invoke(onSelectedImage: (File) -> Unit){
        residentRepository.openFile(onSelectedImage)
    }
}