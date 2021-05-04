package org.xjosiah.mylittleairplay.utils.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "resource",ignoreUnknownFields = false)
@PropertySource("classpath:application.properties")
@Data
@Component
public class ResourceProperties {
    private String path;
    private String albumcoverpath;
}
