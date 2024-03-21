plugins {
    java
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.prueba"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

tasks.bootJar {
    mainClass = "com.prueba.juego_piedra_papel_tijera.JuegoPiedraPapelTijeraApplication"
}

allprojects {

    repositories {
        mavenCentral()
    }
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.2")
    implementation("io.swagger.core.v3:swagger-models:2.2.2")
    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-boot-starter:3.0.0")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

subprojects {
    apply(plugin = "java")

    java.sourceCompatibility = JavaVersion.VERSION_17

}

configure(project.subprojects.filter { it != project(":dominio") }) {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {

        implementation("org.springframework.boot:spring-boot-starter-web")


    }
}


tasks.withType<Test> {
    useJUnitPlatform()
}





