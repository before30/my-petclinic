package cc.before30.petclinic.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class MyPetclinicConfigServerApplication

fun main(args: Array<String>) {
    runApplication<MyPetclinicConfigServerApplication>(*args)
}
