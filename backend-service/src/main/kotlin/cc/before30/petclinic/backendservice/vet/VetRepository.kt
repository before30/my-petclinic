package cc.before30.petclinic.backendservice.vet

import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

interface VetRepository : Repository<Vet, Int> {

    /**
     * Retrieve all <code>Vet</code>s from the data store.
     *
     * @return a <code>Collection</code> of <code>Vet</code>s
     */
    @Transactional(readOnly = true)
    @Cacheable("vets")
    fun findAll(): Collection<Vet>

}
