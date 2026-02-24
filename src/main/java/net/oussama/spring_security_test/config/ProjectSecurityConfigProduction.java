package net.oussama.spring_security_test.config;

import net.oussama.spring_security_test.exceptionhandler.CustomerBasicAuthenEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

@Configuration
@Profile("prod")
public class ProjectSecurityConfigProduction {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
     //  http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        http.redirectToHttps((rcc)->rcc.requestMatchers(AnyRequestMatcher.INSTANCE));
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests((requests) ->{
                    requests.requestMatchers("/myaccount","/mybalance","/cards","/loans").authenticated();
                    requests.requestMatchers("/contact","/notice","/error","/api/create").permitAll();});
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.authenticationEntryPoint(new CustomerBasicAuthenEntryPoint()));
        return http.build();
    }



    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    /* @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    } */

}
