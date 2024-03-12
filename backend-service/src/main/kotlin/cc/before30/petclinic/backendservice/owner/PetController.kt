package cc.before30.petclinic.backendservice.owner


import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.util.StringUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid

@Controller
@RequestMapping("/owners/{ownerId}")
class PetController(val pets: PetRepository, val owners: OwnerRepository) {

    private val VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm"

    @ModelAttribute("types")
    fun populatePetTypes(): Collection<PetType> = this.pets.findPetTypes()

    @ModelAttribute("owner")
    fun findOwner(@PathVariable("ownerId") ownerId: Int): Owner
            = owners.findById(ownerId)

    @InitBinder("owner")
    fun initOwnerBinder(dataBinder: WebDataBinder) {
        dataBinder.setDisallowedFields("id")
    }

    @InitBinder("pet")
    fun initPetBinder(dataBinder: WebDataBinder) {
        dataBinder.validator = PetValidator()
    }

    @GetMapping("/pets/new")
    fun initCreationForm(owner: Owner, model: Model): String {
        val pet = Pet()
        owner.addPet(pet)
        model["pet"] = pet
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM
    }

    @PostMapping("/pets/new")
    fun processCreationForm(owner: Owner, @Valid pet: Pet, result: BindingResult, model: Model): String {
        if (StringUtils.hasLength(pet.name) && pet.isNew && owner.getPet(pet.name!!, true) != null) {
            result.rejectValue("name", "duplicate", "already exists")
        }
        owner.addPet(pet)
        return if (result.hasErrors()) {
            model["pet"] = pet
            VIEWS_PETS_CREATE_OR_UPDATE_FORM
        } else {
            this.pets.save(pet)
            "redirect:/owners/{ownerId}"
        }
    }

    @GetMapping("/pets/{petId}/edit")
    fun initUpdateForm(@PathVariable petId: Int, model: Model): String {
        val pet = pets.findById(petId)
        model["pet"] = pet
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM
    }

    @PostMapping("/pets/{petId}/edit")
    fun processUpdateForm(@Valid pet: Pet, result: BindingResult, owner: Owner, model: Model): String {
        return if (result.hasErrors()) {
            pet.owner = owner
            model["pet"] = pet
            VIEWS_PETS_CREATE_OR_UPDATE_FORM
        } else {
            owner.addPet(pet)
            pets.save(pet)
            "redirect:/owners/{ownerId}"
        }
    }

}
