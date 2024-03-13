package cc.before30.petclinic.discovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class MyPetclinicDiscoveryServerApplication

fun main(args: Array<String>) {
    runApplication<MyPetclinicDiscoveryServerApplication>(*args)
}
