package resident_feature.data.data_source

import kotlinx.coroutines.flow.Flow
import resident_feature.domain.model.Resident

interface ResidentDao {

    fun getResidents(): Flow<List<Resident>>
    suspend fun addResident(resident: Resident)
    suspend fun updateResident(resident: Resident)
    suspend fun deleteResident(residentId: Int)



}