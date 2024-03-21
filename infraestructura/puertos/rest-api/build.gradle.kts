import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":dominio"))
}

tasks.named<BootJar>("bootJar").configure {
    enabled = false
}
