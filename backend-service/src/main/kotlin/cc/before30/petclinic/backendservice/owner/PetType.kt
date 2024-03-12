package cc.before30.petclinic.backendservice.owner

import cc.before30.petclinic.backendservice.model.NamedEntity
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
open class PetType : NamedEntity()
