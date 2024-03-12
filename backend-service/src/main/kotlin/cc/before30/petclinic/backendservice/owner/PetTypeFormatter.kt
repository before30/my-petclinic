package cc.before30.petclinic.backendservice.owner


import org.springframework.format.Formatter
import org.springframework.stereotype.Component
import java.text.ParseException
import java.util.*

@Component
class PetTypeFormatter(val pets: PetRepository) : Formatter<PetType> {

    override fun print(petType: PetType, locale: Locale): String
                = petType.name ?: ""


    override fun parse(text: String, locale: Locale): PetType {
        val findPetTypes = this.pets.findPetTypes()
        return findPetTypes.find { it.name == text } ?:
                    throw ParseException("type not found: " + text, 0)
    }

}
