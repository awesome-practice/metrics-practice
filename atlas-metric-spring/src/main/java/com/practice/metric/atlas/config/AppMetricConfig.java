package com.practice.metric.atlas.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Luo Bao Ding
 * @since 2019/1/30
 */
@Configuration
public class AppMetricConfig {

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricCommonTags() {
        return registry -> {
            registry.config().commonTags("application", "atlas-metric-spring");
        };
    }
}
