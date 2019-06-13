package com.practice.metric.dropwizard.config;

import com.practice.metric.dropwizard.metric.AdditionalTomcatMetricsBinder;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Luo Bao Ding
 * @since 2019/1/31
 */
@Configuration
public class AdditionalTomcatMetricsConfiguration {

    @Bean
    public AdditionalTomcatMetricsBinder additionalTomcatMetricsBinder(MeterRegistry meterRegistry) {
        return new AdditionalTomcatMetricsBinder(meterRegistry);
    }


}
