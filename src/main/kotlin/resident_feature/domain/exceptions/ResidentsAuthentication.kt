package resident_feature.domain.exceptions

sealed class ResidentsAuthentication{
     class FullNameException(message: String) : Exception(message)
     class ResidentsAuthentication(message: String) :Exception(message)
     class AddressException(message: String) :Exception(message)
     class ReligionException(message: String): Exception(message)
     class ContactNumberException(message: String): Exception(message)
     class PurokException(message: String): Exception(message)
     class OccupationException(message: String): Exception(message)
     class CitizenshipException(message: String): Exception(message)
     class DateException(message: String): Exception(message)
     class EducationalAttainmentException(message: String): Exception(message)
}
