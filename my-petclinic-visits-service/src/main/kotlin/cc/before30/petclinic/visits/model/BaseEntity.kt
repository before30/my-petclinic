package cc.before30.petclinic.visits.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@MappedSuperclass
open class BaseEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int? = null
) {
    val isNew: Boolean
        get() = this.id == null
}
