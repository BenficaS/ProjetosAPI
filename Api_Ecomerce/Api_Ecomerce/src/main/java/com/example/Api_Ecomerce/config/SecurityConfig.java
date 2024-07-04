package com.example.Api_Ecomerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/nomeusuario/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/edicao/**").hasRole("ADMIN")
                        .requestMatchers("/update/**").hasRole("ADMIN")
                        .requestMatchers("/produtos/**").hasRole("GERENTE")
                        .requestMatchers("/gerente/**").hasRole("GERENTE")
                        .requestMatchers("/vendedores/**").hasRole("VENDEDOR")
                        .requestMatchers("/pedidos/**").hasRole("VENDEDOR")
                        .requestMatchers("/produtos/**").hasRole("CLIENTE")
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("gabriel")
                .password(passwordEncoder().encode("1"))
                .roles("ADMIN")
                .build();
        UserDetails gerente = User.builder()
                .username("camila")
                .password(passwordEncoder().encode("1"))
                .roles("GERENTE")
                .build();
        UserDetails vendedor = User.builder()
                .username("jairo ")
                .password(passwordEncoder().encode("1"))
                .roles("VENDEDOR")
                .build();
        UserDetails cliente = User.builder()
                .username("selma")
                .password(passwordEncoder().encode("1"))
                .roles("CLIENTE")
                .build();
        return new InMemoryUserDetailsManager(gerente, admin,vendedor);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
