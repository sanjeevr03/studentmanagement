package com.sanjeev.studentmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.sanjeev.studentmanagement.security.JwtAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import com.sanjeev.studentmanagement.service.CustomUserDetailsService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
public class SecurityConfig {
        @Autowired
private JwtAuthenticationFilter jwtAuthenticationFilter;
        @Autowired
private CustomUserDetailsService customUserDetailsService;

  
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

      http
    .csrf(csrf -> csrf.disable())
    .authenticationProvider(authenticationProvider())
    .authorizeHttpRequests(auth -> auth
           .requestMatchers("/login", "/register").permitAll()
            .anyRequest().authenticated())
    .addFilterBefore(jwtAuthenticationFilter,
            UsernamePasswordAuthenticationFilter.class)
    .httpBasic(Customizer.withDefaults());

        return http.build();
    }
    @Bean
public AuthenticationManager authenticationManager(
        AuthenticationConfiguration configuration) throws Exception {

    return configuration.getAuthenticationManager();
}
@Bean
public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
}
@Bean
public AuthenticationProvider authenticationProvider() {

    DaoAuthenticationProvider provider =
            new DaoAuthenticationProvider(customUserDetailsService);

    provider.setPasswordEncoder(passwordEncoder());

    return provider;
}
}   