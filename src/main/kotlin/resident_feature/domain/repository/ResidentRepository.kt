package resident_feature.domain.repository

import kotlinx.coroutines.flow.Flow
import resident_feature.domain.model.Resident

interface ResidentRepository {
    fun getResidents(): Flow<List<Resident>>
    suspend fun addResident(resident: Resident)
    suspend fun updateResident(resident: Resident)
    suspend fun deleteResident(resident: Resident)
    suspend fun archiveResident(resident: Resident)
}