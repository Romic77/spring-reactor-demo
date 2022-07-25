package com.reactor.demo.ext;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author romic
 * @date 2022/7/25
 * 自定义端口返回信息
 */
@Component
public class ConfigServerHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        try {
            final HttpURLConnection conn = (HttpURLConnection) new URL("http://localhost:8888/configservice/default").openConnection();
            int statusCode = conn.getResponseCode();
            if (statusCode >= 200 && statusCode < 300) {
                return Health.up().build();
            }
            return Health.down().withDetail("http status code", statusCode).build();
        } catch (IOException e) {
            e.printStackTrace();
            return Health.down(e).build();
        }
    }
}
