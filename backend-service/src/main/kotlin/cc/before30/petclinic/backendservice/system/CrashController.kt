package cc.before30.petclinic.backendservice.system

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CrashController {

    @GetMapping("/oups")
    fun triggerException() {
        throw RuntimeException(
                "Expected: controller used to showcase what happens when an exception is thrown")
    }

}
