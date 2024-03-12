package cc.before30.petclinic.backendservice.visit

import cc.before30.petclinic.backendservice.model.BaseEntity
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty

@Entity
@Table(name = "visits")
class Visit : BaseEntity() {

    /**
     * Holds value of property date.
     */
    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var date: LocalDate = LocalDate.now()

    /**
     * Holds value of property description.
     */
    @NotEmpty
    @Column(name = "description")
    var description: String? = null


    /**
     * Holds value of property owner.
     */
    @Column(name = "pet_id")
    var petId: Int? = null
}
