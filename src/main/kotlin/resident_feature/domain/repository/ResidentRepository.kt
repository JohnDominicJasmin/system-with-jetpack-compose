package resident_feature.domain.repository

import kotlinx.coroutines.flow.Flow
import resident_feature.domain.model.Resident
import java.io.File

interface ResidentRepository {
    fun getResidents(): Flow<List<Resident>>
    suspend fun addResident(resident: Resident)
    suspend fun updateResident(resident: Resident)
    suspend fun deleteResident(residentId: Int)
    fun openFile(onSelectedImage: (File) -> Unit)
}