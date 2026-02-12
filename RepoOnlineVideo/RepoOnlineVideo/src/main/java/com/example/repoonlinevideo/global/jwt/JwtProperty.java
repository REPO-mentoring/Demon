package com.example.repoonlinevideo.global.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperty {
    private String secretKey;
    private Long accessExp;
    private Long refreshExp;
    private String header;
    private String prefix;

}
