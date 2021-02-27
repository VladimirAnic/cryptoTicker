package com.ticker.cryptoTicker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
public class CryptoTickerApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(CryptoTickerApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Hello this is an info message");
        SpringApplication.run(CryptoTickerApplication.class, args);
    }

}
