package com.practice.metric.dropwizard;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MetricsDropwizardPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetricsDropwizardPracticeApplication.class, args);
    }


}

