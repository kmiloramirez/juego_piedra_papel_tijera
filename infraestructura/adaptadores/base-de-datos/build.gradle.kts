import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation(project(":dominio"))
    implementation("org.flywaydb:flyway-core")
    implementation("org.springframework.data:spring-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")

}

tasks.named<BootJar>("bootJar").configure {
    enabled = false
}

