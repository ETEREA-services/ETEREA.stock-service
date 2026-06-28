## [1.0.1] - 2026-06-28
- fix: Corregido patrón de serialización de fechas ISO 8601 (`Z` → `XX`) para compatibilidad con zonas horarias en `ArticuloFechaDto`, `ArticuloMovimientoDto`, `InventarioDto`, `StockMovimientoDto` y `ArticuloStockDto`
- chore(deps): Actualización de dependencias:
  - Spring Boot Starter Parent 4.0.6 → 4.1.0
  - Spring Cloud 2025.1.0 → 2025.1.2
  - SpringDoc OpenAPI 3.0.2 → 3.0.3

## [1.0.0] - 2026-06-10
- chore: Actualización masiva de dependencias:
  - Spring Boot Starter Parent 3.5.6 → 4.0.6
  - Spring Cloud 2025.0.0 → 2025.1.0
  - SpringDoc OpenAPI 2.8.10 → 3.0.2
  - Apache POI 5.4.1 → 5.5.1
  - commons-lang3 3.18.0 → 3.20.0
- feat: Nueva dependencia commons-fileupload 1.6.0 para carga de archivos
- feat: Método `jsonify()` en DTOs (`ArticuloBarraDto`, `ArticuloDto`, `ArticuloStockDto`) usando `Jsonifier`
- refactor: Migración de DTOs de `@Data` a `@Getter/@Setter/@Builder/@NoArgsConstructor/@AllArgsConstructor`
- refactor: Renombre de campos en `ArticuloDto` (`cuentaVentas` → `numeroCuentaVentas`, `cuentaCompras` → `numeroCuentaCompras`, `cuentaGastos` → `numeroCuentaGastos`)
- refactor: Simplificación de logging con `jsonify()` reemplazando `JsonMapper` manual en controladores y servicios
- refactor: Migración a `@RequiredArgsConstructor` de Lombok en `StockArticuloController`, `ControlInventarioController`, `StockArticuloService`, `ControlInventarioService`
- chore: Eliminación de `<executable>true</executable>` del plugin spring-boot-maven-plugin
- ci: Actualización de Actions (checkout@v6, setup-java@v5, cache@v5, docker/login-action@v4, metadata-action@v6, buildx-action@v4, build-push-action@v7, upload-pages-artifact@v4, deploy-pages@v5)
- ci: Cambio en el path de artefactos Pages (`_site` → `docs`)

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