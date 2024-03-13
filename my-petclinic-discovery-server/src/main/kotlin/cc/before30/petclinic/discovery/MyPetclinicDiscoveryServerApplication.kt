package cc.before30.petclinic.discovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyPetclinicDiscoveryServerApplication

fun main(args: Array<String>) {
    runApplication<MyPetclinicDiscoveryServerApplication>(*args)
}
