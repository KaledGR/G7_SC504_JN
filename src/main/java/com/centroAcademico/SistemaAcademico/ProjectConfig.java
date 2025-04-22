/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.centroAcademico.SistemaAcademico;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 *
 * @author gonza
 */
@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    /* Los siguiente métodos son para implementar el tema de seguridad dentro del proyecto */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/index", "/errores/**",
                        "/layout/indexmejorado", "/pruebas/**", "/reportes/**",
                        "/registro/**", "/js/**", "/webjars/**", "/tarea3/**")
                .permitAll()
                .requestMatchers(
                        "/estudiante/nuevo", "/estudiante/guardar","/estudiante/actualizar",
                        "/estudiante/modificar/**", "/estudiante/eliminar/**",
                        "/profesores/nuevo", "/profesores/guardar","/profesores/actualizar",
                        "/profesores/modificar/**", "/profesores/eliminar/**",
                        "/usuario/nuevo", "/usuario/guardar", "/usuario/actualizar",
                        "/usuario/modificar/**", "/usuario/eliminar/**",
                        "/materias/nuevo", "/materias/guardar", "/materias/actualizar",
                        "/materias/modificar/**", "/materias/eliminar/**",
                        "/rol/nuevo", "/rol/guardar","/rol/actualizar",
                        "/rol/modificar/**", "/rol/eliminar/**",
                        "/horarios/nuevo", "/horarios/guardar", "/horarios/actualizar",
                        "/horarios/modificar/**", "/horarios/eliminar/**"
                ).hasRole("ADMIN")
                .requestMatchers(
                        "/estudiante/listado",
                        "/materias/listado",
                        "/profesores/listado",
                        "/horarios/listado",
                        "/rol/listado",
                        "/usuario/listado"
                ).hasAnyRole("ADMIN", "VENDEDOR")
                .requestMatchers("/facturar/carrito")
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build)
            throws Exception {
        build.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
