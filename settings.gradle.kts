rootProject.name = "juego_piedra_papel_tijera"

include(":dominio")
project(":dominio").projectDir = file("./dominio")
include(":aplicacion")
project(":aplicacion").projectDir = file("./aplicacion")
include(":rest-api")
project(":rest-api").projectDir = file("./infraestructura/puertos/rest-api")
include(":base-de-datos")
project(":base-de-datos").projectDir = file("./infraestructura/adaptadores/base-de-datos")
