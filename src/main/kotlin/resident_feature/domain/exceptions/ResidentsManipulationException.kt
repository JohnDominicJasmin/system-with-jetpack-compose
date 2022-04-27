package resident_feature.domain.exceptions

sealed class ResidentsAuthentication{
     class FullNameException(message: String) : RuntimeException(message)
     class ResidentsManipulationException(message: String) :RuntimeException(message)
     class AddressException(message: String) :RuntimeException(message)
     class ReligionException(message: String): RuntimeException(message)
     class ContactNumberException(message: String): RuntimeException(message)
     class PurokException(message: String): RuntimeException(message)
     class OccupationException(message: String): RuntimeException(message)
     class CitizenshipException(message: String): RuntimeException(message)
     class DateException(message: String): RuntimeException(message)
     class EducationalAttainmentException(message: String): RuntimeException(message)
     class ProfileImageException(message: String): RuntimeException(message)
}
