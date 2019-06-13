package com.practice.metric.atlas.config;

import com.practice.metric.atlas.metric.AdditionalTomcatMetricsBinder;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
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
        return  new AdditionalTomcatMetricsBinder(meterRegistry);
    }


}
