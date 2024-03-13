package cc.before30.petclinic.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyPetclinicAdminServerApplication

fun main(args: Array<String>) {
	runApplication<MyPetclinicAdminServerApplication>(*args)
}
