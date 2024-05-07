package com.example.foodOrder.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ResourceServerConfig {

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(oath2 -> oath2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
        http.authorizeHttpRequests(requests -> requests.requestMatchers(HttpMethod.GET,"/foodapi/foods/{name:^[a-zA-Z]*$}")
                .hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST, "/foodapi/foods").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/userapi/user").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/userapi/user/{username:^[a-z0-9]*$}").hasRole("ADMIN")
                .anyRequest().authenticated());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
