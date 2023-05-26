package com.ferru97.s4f.user.microservice.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "s4f.security")
public class SecurityProperties {

    private int bcryptStrength;

    private String bcryptRandomSeed;

}
