package net.oussama.spring_security_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
     //  http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        http.authorizeHttpRequests((requests) ->{
                    requests.requestMatchers("/myaccount","/mybalance","/cards","/loans").authenticated();
                    requests.requestMatchers("/contact","/notice","/error ").permitAll();});
        http.formLogin(fls -> fls.disable());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
