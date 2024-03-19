package cc.before30.petclinic.visits.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.NotEmpty
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

@Entity
@Table(name = "visits")
class VisitEntity : BaseEntity() {

    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var date: LocalDate = LocalDate.now()

    @NotEmpty
    @Column(name = "description")
    var description: String? = null

    @Column(name = "pet_id")
    var petId: Int? = null

}
