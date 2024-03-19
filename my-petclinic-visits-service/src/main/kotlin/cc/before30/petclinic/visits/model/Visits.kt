package cc.before30.petclinic.visits.model

import jakarta.xml.bind.annotation.XmlRootElement

@XmlRootElement
data class Visits(var visits: Collection<VisitEntity>? = null)
