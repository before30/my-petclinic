package cc.before30.mypetclinic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyPetclinicApplication

fun main(args: Array<String>) {
    runApplication<MyPetclinicApplication>(*args)
}
