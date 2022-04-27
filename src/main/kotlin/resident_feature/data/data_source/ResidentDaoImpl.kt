package resident_feature.data.data_source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import resident_feature.common.Constants.CONNECTION_URL
import resident_feature.domain.exceptions.ResidentsAuthentication
import resident_feature.domain.model.Resident
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.Statement

class ResidentDaoImpl(
    private val connection: Connection = DriverManager.getConnection(CONNECTION_URL)
) : ResidentDao {

    override fun getResidents(): Flow<List<Resident>> = flow {
        val statement: Statement = connection.createStatement()
        val resultSet = statement.executeQuery("SELECT * FROM RESIDENTS")

        while (resultSet.next()) {

            emit(
                value = listOf(
                    Resident(
                        id = resultSet.getInt("ID"),
                        fullName = resultSet.getString("FULLNAME"),
                        suffix = resultSet.getString("SUFFIX"),
                        sex = resultSet.getString("SEX"),
                        dateOfBirth = resultSet.getString("BIRTHDATE"),
                        age = resultSet.getString("AGE"),
                        occupation = resultSet.getString("OCCUPATION"),
                        religion = resultSet.getString("RELIGION"),
                        educationalAttainment = resultSet.getString("EDUCATIONAL_ATTAINMENT"),
                        purok = resultSet.getString("PUROK"),
                        address = resultSet.getString("ADDRESS"),
                        civilStatus = resultSet.getString("CIVIL_STATUS"),
                        voter = resultSet.getString("REGISTERED_VOTER"),
                        contactNumber = resultSet.getString("CONTACT_NUMBER"),
                        citizenship = resultSet.getString("CITIZENSHIP"),
                        seniorCitizen = resultSet.getString("SENIOR_CITIZEN"),
                        localImagePath = resultSet.getString("IMAGE_PATH"),
                        imageName = resultSet.getString("IMAGE_NAME")


                    )
                )
            )
        }
        statement.close()
        connection.close()

    }

    override suspend fun addResident(resident: Resident) {


        try {
            val statement: PreparedStatement = connection.prepareStatement(
                "INSERT INTO Residents (FULLNAME, SUFFIX, SEX, BIRTHDATE, AGE, OCCUPATION, RELIGION, EDUCATIONAL_ATTAINMENT, PUROK, ADDRESS, CIVIL_STATUS, REGISTERED_VOTER, CONTACT_NUMBER, CITIZENSHIP, SENIOR_CITIZEN, IMAGE_PATH, IMAGE_NAME)\n" +
                        "VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? )"
            )

            with(statement) {
                with(resident) {
                    setString(1, fullName.trimEnd())
                    setString(2, suffix.trimEnd())
                    setString(3, sex.trimEnd())
                    setString(4, dateOfBirth.trimEnd())
                    setString(5, age.trimEnd())
                    setString(6, occupation.trimEnd())
                    setString(7, religion.trimEnd())
                    setString(8, educationalAttainment.trimEnd())
                    setString(9, purok.trimEnd())
                    setString(10, address.trimEnd())
                    setString(11, civilStatus.trimEnd())
                    setString(12, voter.trimEnd())
                    setString(13, contactNumber.trimEnd())
                    setString(14, citizenship.trimEnd())
                    setString(15, seniorCitizen.trimEnd())
                    setString(16, localImagePath)
                    setString(17, imageName)
                }
            }

            if (statement.executeUpdate() == 0) {
                throw RuntimeException("Failed to Add Resident '${resident.fullName.uppercase()}'.")
            }

        } catch (error: Exception) {
            error.message?.let{ errorMessage ->

                handleManipulationException(errorMessage, resident)

            }
        }

    }
    private fun handleManipulationException(errorMessage: String, resident: Resident){
        if(errorMessage.contains("FULLNAME")){
            throw ResidentsAuthentication.ResidentsManipulationException(message = "Name '${resident.fullName}' is already used!")
        }
        if(errorMessage.contains("CONTACT_NUMBER")){
            throw ResidentsAuthentication.ResidentsManipulationException(message = "Contact Number '${resident.contactNumber}' is already used.")
        }
        if(errorMessage.contains("IMAGE_NAME")){
            throw ResidentsAuthentication.ResidentsManipulationException(message = "Image is already used.")
        }
        throw ResidentsAuthentication.ResidentsManipulationException(message = errorMessage)
    }

    override suspend fun updateResident(resident: Resident) {

        try {
            val statement: PreparedStatement =
                connection.prepareStatement("UPDATE Residents SET FULLNAME = ?, SUFFIX = ?, SEX = ?, BIRTHDATE = ?, AGE = ?, OCCUPATION = ?, RELIGION = ?, EDUCATIONAL_ATTAINMENT = ?, PUROK = ?, ADDRESS = ?, CIVIL_STATUS = ?, REGISTERED_VOTER = ?, CONTACT_NUMBER = ?, CITIZENSHIP = ?, SENIOR_CITIZEN = ?, IMAGE_PATH = ?, IMAGE_NAME = ? WHERE ID = ?")


            with(statement) {
                with(resident) {
                    setString(1, fullName)
                    setString(2, suffix)
                    setString(3, sex)
                    setString(4, dateOfBirth)
                    setString(5, age)
                    setString(6, occupation)
                    setString(7, religion)
                    setString(8, educationalAttainment)
                    setString(9, purok)
                    setString(10, address)
                    setString(11, civilStatus)
                    setString(12, voter)
                    setString(13, contactNumber)
                    setString(14, citizenship)
                    setString(15, seniorCitizen)
                    setString(16, localImagePath)
                    setString(17, imageName)
                    setInt(18, id)
                }
            }

            if(statement.executeUpdate() == 0){
                throw RuntimeException("Failed to Update Resident '${resident.fullName.uppercase()}'.")
            }
        }catch (error: Exception) {
            error.message?.let { errorMessage ->
                handleManipulationException(errorMessage, resident)
            }
        }
    }

    override suspend fun deleteResident(residentId: Int) {


        try {
            val statement: PreparedStatement =
                connection.prepareStatement("DELETE FROM Residents WHERE ID = ?")

                    statement.setInt(1, residentId)

            if (statement.executeUpdate() == 0) {
                throw RuntimeException("Failed to Delete Resident!")
            }

        } catch (e: Exception) {
            throw ResidentsAuthentication.ResidentsManipulationException(message = e.message ?: "Failed to Delete Resident ")
        }


    }






}