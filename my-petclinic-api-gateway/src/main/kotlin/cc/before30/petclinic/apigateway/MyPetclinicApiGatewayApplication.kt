package cc.before30.petclinic.apigateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyPetclinicApiGatewayApplication

fun main(args: Array<String>) {
    runApplication<MyPetclinicApiGatewayApplication>(*args)
}
