package cc.before30.petclinic.visits.model

import org.springframework.data.repository.Repository

interface VisitRepository : Repository<VisitEntity, Int> {
    fun save(visitEntity: VisitEntity)

    fun findByPetId(petId: Int): MutableSet<VisitEntity>

    fun findAll(): MutableSet<VisitEntity>
}
