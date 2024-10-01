package eterea.stock.service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "core-service/api/core/articulosaldofecha")
public interface ArticuloSaldoFechaClient {
}
