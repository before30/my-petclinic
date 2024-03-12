package cc.before30.petclinic.backendservice.owner


import cc.before30.petclinic.backendservice.model.Person
import java.util.*
import jakarta.persistence.*
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.NotEmpty

@Entity
@Table(name = "owners")
class Owner : Person() {
    @Column(name = "address")
    @NotEmpty
    var address = ""

    @Column(name = "city")
    @NotEmpty
    var city = ""

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    var telephone = ""

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "owner")
    var pets: MutableSet<Pet> = HashSet()


    fun getPets(): List<Pet> =
            pets.sortedWith(compareBy({ it.name }))


    fun addPet(pet: Pet) {
        if (pet.isNew) {
            pets.add(pet)
        }
        pet.owner = this
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if owner name is already in use
     */
    fun getPet(name: String): Pet? =
            getPet(name, false)

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if owner name is already in use
     */
    fun getPet(name: String, ignoreNew: Boolean): Pet? {
        val lname = name.lowercase()
        for (pet in pets) {
            if (!ignoreNew || !pet.isNew) {
                val compName = pet.name?.lowercase()
                if (compName == lname) {
                    return pet
                }
            }
        }
        return null
    }

}
