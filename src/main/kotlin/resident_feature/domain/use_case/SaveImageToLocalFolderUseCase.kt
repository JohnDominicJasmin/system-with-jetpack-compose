package resident_feature.domain.use_case

import resident_feature.data.repository.ResidentRepositoryImpl
import resident_feature.domain.repository.ResidentRepository

class SaveImageToLocalFolderUseCase(private val residentRepository: ResidentRepository = ResidentRepositoryImpl()) {
    suspend operator fun invoke(filePath: String, fileName: String){
        residentRepository.saveImageToLocalFolder(filePath, fileName)
    }
}