package com.igor.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public final class CalculatorApplication {

    private CalculatorApplication() {
    }

    public static void main(final String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}
