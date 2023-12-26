package com.cos.security1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig //extends WebSecurityConfigurerAdapter
{

    // @Override
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) {
        try {
//           return http.cors()
//                    .and()
//                    .csrf().disable()
//                    .httpBasic().disable()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                    .and()
//                    .authorizeRequests().antMatchers("/", "/auth/**").permitAll()
//                    .anyRequest().authenticated();

            http.csrf(AbstractHttpConfigurer::disable)
//                    .httpBasic(AbstractHttpConfigurer::disable)
//                    .cors(Customizer.withDefaults())
//                    .sessionManagement((sessionManagement) ->
//                            sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                    )

                    .authorizeHttpRequests((authorizeRequests) ->
                            authorizeRequests.requestMatchers("/user/**").authenticated()
                                    .requestMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER")
                                    .requestMatchers("/admin/**").hasRole("ADMIN")
                                    .anyRequest().permitAll()

                    )
                    .formLogin(login -> login
                            .loginPage("/login")
                            .defaultSuccessUrl("/index", true)
                            .permitAll())
            ;

//            http.addFilterAfter(
//                    jwtAuthenticationFilter,
//                    CorsFilter.class
//            );
            return http.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
