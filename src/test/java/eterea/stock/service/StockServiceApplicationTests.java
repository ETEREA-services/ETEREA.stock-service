package eterea.stock.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "spring.cloud.consul.config.enabled=false",
        "spring.cloud.consul.discovery.enabled=false",
        "spring.cloud.consul.discovery.watch.enabled=false"
})
class StockServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
