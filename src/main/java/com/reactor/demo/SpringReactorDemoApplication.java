package com.reactor.demo;

import com.reactor.demo.config.CustomChannelBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({CustomChannelBinder.class})
@SpringBootApplication
public class SpringReactorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactorDemoApplication.class, args);
    }

}
