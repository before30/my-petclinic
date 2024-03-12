package cc.before30.petclinic.backendservice.vet

import cc.before30.petclinic.backendservice.model.NamedEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
@Entity
@Table(name = "specialties")
class Specialty : NamedEntity()
