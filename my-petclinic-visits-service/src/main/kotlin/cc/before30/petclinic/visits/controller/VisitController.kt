package cc.before30.petclinic.visits.controller

import cc.before30.petclinic.visits.model.VisitRepository
import cc.before30.petclinic.visits.model.Visits
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VisitController(val repository: VisitRepository) {

    @GetMapping("/visits", produces = ["application/json"])
    fun visits() : Visits {
        val visits = repository.findAll()
        return Visits(visits)
    }
}
