package org.jewel.hub.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        RequestMatcher loginMatcher = new AntPathRequestMatcher("/login/**");
        RequestMatcher userMatcher = new AntPathRequestMatcher("/user/**");
        RequestMatcher actuatorMatcher = new AntPathRequestMatcher("/actuator/**");
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection if not needed
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(loginMatcher, userMatcher,actuatorMatcher).permitAll() // Public URLs
                        .anyRequest().authenticated() // Secure all other URLs
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                );
        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
