package cc.before30.petclinic.backendservice.owner


import cc.before30.petclinic.backendservice.model.NamedEntity
import cc.before30.petclinic.backendservice.visit.Visit
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.util.*
import jakarta.persistence.*

@Entity
@Table(name = "pets")
class Pet : NamedEntity() {

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var birthDate: LocalDate? = null

    @ManyToOne
    @JoinColumn(name = "type_id")
    var type: PetType? = null

    @ManyToOne
    @JoinColumn(name = "owner_id")
    var owner: Owner? = null

    @Transient
    var visits: MutableSet<Visit> = LinkedHashSet()


    fun getVisits(): List<Visit> =
            visits.sortedWith(compareBy { it.date })

    fun addVisit(visit: Visit) {
        visits.add(visit)
        visit.petId = this.id
    }

}
