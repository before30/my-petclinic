package cc.before30.petclinic.backendservice.visit

import org.springframework.data.repository.Repository

interface VisitRepository : Repository<Visit, Int> {

    /**
     * Save a `Visit` to the data store, either inserting or updating it.
     *
     * @param visit the `Visit` to save
     * @see BaseEntity.isNew
     */
    fun save(visit: Visit)

    fun findByPetId(petId: Int): MutableSet<Visit>

}
