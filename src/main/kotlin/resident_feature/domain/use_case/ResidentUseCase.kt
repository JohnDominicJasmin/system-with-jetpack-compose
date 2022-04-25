package resident_feature.domain.use_case

data class ResidentUseCase(
    val addResidentUseCase: AddResidentUseCase = AddResidentUseCase(),
    val deleteResidentUseCase: DeleteResidentUseCase = DeleteResidentUseCase(),
    val getResidentsUseCase: GetResidentsUseCase = GetResidentsUseCase(),
    val updateResidentUseCase: UpdateResidentUseCase = UpdateResidentUseCase(),
    val openFileUseCase: OpenFileUseCase = OpenFileUseCase(),
    val saveImageToLocalFolderUseCase: SaveImageToLocalFolderUseCase = SaveImageToLocalFolderUseCase()
)
