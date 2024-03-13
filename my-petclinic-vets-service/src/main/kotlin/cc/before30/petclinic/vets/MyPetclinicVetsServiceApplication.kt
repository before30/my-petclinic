package cc.before30.petclinic.vets

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyPetclinicVetsServiceApplication

fun main(args: Array<String>) {
    runApplication<MyPetclinicVetsServiceApplication>(*args)
}
