
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":dominio"))
    implementation(project(":rest-api"))
    implementation(project(":base-de-datos"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}
tasks.withType<Test> {
    useJUnitPlatform()
}


