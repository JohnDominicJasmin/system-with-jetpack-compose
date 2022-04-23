package resident_feature.data.repository

import kotlinx.coroutines.flow.Flow
import resident_feature.data.data_source.ResidentDao
import resident_feature.data.data_source.ResidentDaoImpl
import resident_feature.domain.model.Resident
import resident_feature.domain.repository.ResidentRepository

class ResidentRepositoryImpl(private val residentDao: ResidentDao = ResidentDaoImpl()): ResidentRepository {
    override fun getResidents(): Flow<List<Resident>> {
        return residentDao.getResidents()
    }

    override suspend fun addResident(resident: Resident){
         residentDao.addResident(resident)
    }

    override suspend fun updateResident(resident: Resident) {
         residentDao.updateResident(resident)
    }

    override suspend fun deleteResident(resident: Resident) {
        residentDao.deleteResident(resident)
    }

    override suspend fun archiveResident(resident: Resident) {
         residentDao.archiveResident(resident)
    }
}