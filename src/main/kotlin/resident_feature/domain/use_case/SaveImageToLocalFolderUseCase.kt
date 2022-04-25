package resident_feature.domain.use_case

import resident_feature.data.repository.ResidentRepositoryImpl
import resident_feature.domain.repository.ResidentRepository
import java.io.File

class SaveImageToLocalFolderUseCase(private val residentRepository: ResidentRepository = ResidentRepositoryImpl()) {
    suspend operator fun invoke(file: File){
        residentRepository.saveImageToLocalFolder(file)
    }
}