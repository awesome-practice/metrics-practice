package com.practice.metric.dropwizard.config;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.CsvReporter;
import com.codahale.metrics.MetricRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.dropwizard.DropwizardConfig;
import io.micrometer.core.instrument.dropwizard.DropwizardMeterRegistry;
import io.micrometer.core.instrument.util.HierarchicalNameMapper;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author Luo Bao Ding
 * @since 2019/1/29
 */
@Configuration
public class AppDropwizardConfig {
    @Bean
    public MetricRegistry dropwizardRegistry() {
        return new MetricRegistry();
    }

    @Bean
    public MeterRegistry consoleLoggingRegistry(MetricRegistry dropwizardRegistry) {
        DropwizardConfig consoleConfig = new DropwizardConfig() {

            @Override
            public String prefix() {
                return "console";
            }

            @Override
            public String get(String key) {
                return null;
            }

        };

        return new DropwizardMeterRegistry(consoleConfig, dropwizardRegistry, HierarchicalNameMapper.DEFAULT, Clock.SYSTEM) {
            @Override
            protected Double nullGaugeValue() {
                return null;
            }
        };


    }

//    @Bean
    public ConsoleReporter consoleReporter(MetricRegistry dropwizardRegistry) {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(dropwizardRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);
        return reporter;
    }

    @Bean
    public CsvReporter csvReporter(MetricRegistry dropwizardRegistry) {
        CsvReporter reporter = CsvReporter.forRegistry(dropwizardRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build(new File("logs"));
        reporter.start(1, TimeUnit.SECONDS);
        return reporter;

    }


}
