package resident_feature.domain.repository

import kotlinx.coroutines.flow.Flow
import resident_feature.domain.model.Resident

interface ResidentRepository {
    fun getResidents(): Flow<List<Resident>>
    suspend fun addResident(resident: Resident): Boolean
    suspend fun updateResident(resident: Resident): Boolean
    suspend fun deleteResident(resident: Resident): Boolean
    suspend fun archiveResident(resident: Resident): Boolean
}