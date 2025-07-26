package eterea.stock.service.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "eterea.stock.service.client")
public class StockConfiguration {
}
