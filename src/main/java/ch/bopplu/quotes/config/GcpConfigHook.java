package ch.bopplu.quotes.config;

import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.autoconfigure.core.GcpProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GcpProperties.class)
public class GcpConfigHook extends GcpContextAutoConfiguration {
    
    public GcpConfigHook(GcpProperties gcpProperties){
        super(gcpProperties);
    }
}
