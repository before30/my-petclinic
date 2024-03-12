package cc.before30.petclinic.backendservice.vet

import cc.before30.petclinic.backendservice.model.Person
import jakarta.persistence.*
import jakarta.xml.bind.annotation.XmlElement

@Entity
@Table(name = "vets")
class Vet : Person() {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = [JoinColumn(name = "vet_id")], inverseJoinColumns = [JoinColumn(name = "specialty_id")])
    var specialties: MutableSet<Specialty> = HashSet()


    @XmlElement
    fun getSpecialties(): List<Specialty> =
            specialties.sortedWith(compareBy { it.name })

    fun getNrOfSpecialties(): Int =
            specialties.size


    fun addSpecialty(specialty: Specialty) =
            specialties.add(specialty)

}
