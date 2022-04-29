package resident_feature.data.repository

import kotlinx.coroutines.flow.Flow
import resident_feature.common.Constants
import resident_feature.data.data_source.ResidentDao
import resident_feature.data.data_source.ResidentDaoImpl
import resident_feature.domain.model.Resident
import resident_feature.domain.repository.ResidentRepository
import java.io.File
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

class ResidentRepositoryImpl(private val residentDao: ResidentDao = ResidentDaoImpl()) : ResidentRepository {
    override fun getResidents(): Flow<List<Resident>> {
        return residentDao.getResidents()
    }

    override suspend fun addResident(resident: Resident) {
        residentDao.addResident(resident)
    }

    override suspend fun updateResident(resident: Resident) {
        residentDao.updateResident(resident)
    }

    override suspend fun deleteResident(residentId: Int) {
        residentDao.deleteResident(residentId)
    }



    override fun openFile(onSelectedImage: (File) -> Unit) {
        val chooser = JFileChooser()
        val file = File(Constants.SELECTED_IMAGE_PATH_DESTINATION).also { folder ->
            if (!folder.exists()) {
                folder.mkdir()
            }
        }
        chooser.apply {
            this.currentDirectory = file
            this.fileFilter = FileNameExtensionFilter("Images", "jpg", "png", "jpeg")
            this.dialogTitle = "Select Profile Image"
        }
            chooser.showOpenDialog(null).apply {
            if(this == JFileChooser.APPROVE_OPTION){
                onSelectedImage(chooser.selectedFile)
            }
        }
    }


}