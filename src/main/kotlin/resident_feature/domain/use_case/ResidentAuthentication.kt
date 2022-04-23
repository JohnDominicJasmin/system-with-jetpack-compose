package resident_feature.domain.use_case

data class ResidentAuthentication(
    val addResidentUseCase: AddResidentUseCase,
    val archiveResidentUseCase: ArchiveResidentUseCase,
    val deleteResidentUseCase: DeleteResidentUseCase,
    val getResidentsUseCase: GetResidentsUseCase,
    val updateResidentUseCase: UpdateResidentUseCase
)
