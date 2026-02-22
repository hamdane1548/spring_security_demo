package net.oussama.spring_security_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
     //  http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        http.authorizeHttpRequests((requests) ->{
                    requests.requestMatchers("/myaccount","/mybalance","/cards","/loans").authenticated();
                    requests.requestMatchers("/contact","/notice","/error ").permitAll();});
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
       UserDetails user =  User.withUsername("oussama").password("{noop}12345").authorities("read").build();
       UserDetails user2 =  User.withUsername("admin").password("{bcrypt}$2a$12$pKl1XPMbQH/YHyPjF4ZY4.YTCQVbHbmPAU4fPRXxqIOiN.mQa2KPS").authorities("admin").build();
       return new InMemoryUserDetailsManager(user,user2);
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
