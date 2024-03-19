package cc.before30.petclinic.visits.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.PastOrPresent
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

@Entity
@Table(name = "visits")
class VisitEntity(
    date: LocalDate,
    description: String,
    petId: Int?
) : BaseEntity() {

    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @field:PastOrPresent
    var date: LocalDate = date

    @field:NotEmpty
    @Column(name = "description")
    var description: String = description

    @Column(name = "pet_id")
    var petId: Int? = petId

}
