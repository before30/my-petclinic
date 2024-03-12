package cc.before30.petclinic.backendservice.vet

import jakarta.xml.bind.annotation.XmlRootElement

/**
 * Simple domain object representing a list of veterinarians. Mostly here to be used for the 'vets' [ ].
 *
 * @author Arjen Poutsma
 * @author Antoine Rey
 */
@XmlRootElement
data class Vets(var vetList: Collection<Vet>? = null)
