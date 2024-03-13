import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = true

plugins{
    id("io.gatling.gradle") version "3.9.5.1"
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:4.1.0")
    implementation("org.springframework.cloud:spring-cloud-starter-config:4.1.0")
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.5")

}
