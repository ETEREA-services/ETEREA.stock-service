## [0.4.2] - 2025-10-15
- chore: Actualización de JDK de 24 a 25 en pom.xml, Dockerfile y workflow de CI
- refactor: Mejora de controladores y servicios usando @RequiredArgsConstructor de Lombok (eliminación de constructores manuales en AjustesController y AjustesService)

## [0.4.1] - 2025-09-21
- chore: Actualización de dependencias:
  - Spring Boot Starter Parent a 3.5.6

## [0.4.0] - 2025-09-07
 - feat: Añadido utilitario `Jsonifier` para serialización JSON uniforme en DTOs.
 - feat: Nuevos constructores y métodos `jsonify()` en DTOs (`StockMovimientoDto`, `ArticuloAjusteDto`, `RubroDto`, `StockAndArticulosDto`, `StockResponseDto`).
 - refactor: Centralización del logging de objetos en servicios usando `jsonify()`.
 - chore: Actualización de dependencias:
	 - Spring Boot Starter Parent a 3.5.5
	 - SpringDoc OpenAPI a 2.8.10
 - fix: Mejoras de permisos y seguridad en el `Dockerfile`.
 - docs: Actualización de diagramas y documentación técnica para reflejar los nuevos DTOs y utilidades.

## [0.3.0] - 2025-08-05
...existing code...