# ETEREA.stock-service

[![ETEREA.stock-service CI](https://github.com/ETEREA-services/ETEREA.stock-service/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/ETEREA-services/ETEREA.stock-service/actions/workflows/maven.yml)
[![Java Version](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/technologies/downloads/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-green.svg)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.0.0-blue.svg)](https://spring.io/projects/spring-cloud)
[![SpringDoc OpenAPI](https://img.shields.io/badge/SpringDoc%20OpenAPI-2.8.9-blue.svg)](https://springdoc.org/)
[![Version](https://img.shields.io/badge/Version-0.1.0-blue.svg)](https://github.com/ETEREA-services/ETEREA.stock-service/releases/tag/v0.1.0)

## Descripción

El Servicio de Gestión de Stock es un componente esencial del sistema ETEREA que se encarga de:

- Gestión de inventario y stock
- Control de movimientos de almacén
- Seguimiento de productos y artículos
- Integración con otros servicios del sistema
- Reportes y análisis de inventario

## Tecnologías Principales

- **Java 21**: Lenguaje de programación principal
- **Spring Boot 3.5.3**: Framework de desarrollo
- **Spring Cloud 2025.0.0**: Microservicios y cloud
- **SpringDoc OpenAPI 2.8.9**: Documentación de API
- **Apache POI 5.4.1**: Procesamiento de archivos Excel
- **Lombok**: Reducción de código boilerplate
- **Caffeine**: Caché de alto rendimiento
- **Spring Validation**: Validación de datos

## Documentación

- [Documentación Técnica](docs/index.md)
- [API Documentation](docs/api-documentation.html)
- [Guía de Despliegue](docs/deployment-guide.html)
- [Changelog](CHANGELOG.md)

## Desarrollo

### Requisitos

- Java 21
- Maven 3.9+
- Docker (opcional)

### Compilación

```bash
mvn clean install
```

### Ejecución

```bash
mvn spring-boot:run
```

## Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).