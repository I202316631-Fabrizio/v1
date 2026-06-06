Hotel Independencia — Gestión de Reservas
Propósito: API REST para gestionar Reservas, Habitaciones, Servicios Adicionales y Pagos.

Stack: Java 17 · Spring Boot · Spring Data JPA · Maven (incluye mvnw).

Estructura clave
src/main/java/com/cibertec/gestionHotel — model, repository, service, controller

src/main/resources — application.properties (sin credenciales)

pom.xml, mvnw, .mvn/wrapper, .gitignore, .gitattributes

Ejecutar (comando mínimo)
bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
Nota: No incluir credenciales en el repo; usar variables de entorno o application-local.yml excluido por .gitignore.

Endpoints principales (base URL http://localhost:8080)
Reservas: GET /reservas, GET /reservas/{id}, POST /reservas, PUT /reservas/{id}, DELETE /reservas/{id}

Habitaciones: GET /habitaciones, GET /habitaciones/{id}

Servicios Adicionales: GET /servicios-adicionales, POST /servicios-adicionales, PUT /servicios-adicionales/{id}, DELETE /servicios-adicionales/{id}

Pagos: POST /pagos (simulado)
