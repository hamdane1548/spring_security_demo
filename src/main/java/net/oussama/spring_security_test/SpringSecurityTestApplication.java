package net.oussama.spring_security_test;

import lombok.AllArgsConstructor;
import net.oussama.spring_security_test.Entity.Customers;
import net.oussama.spring_security_test.Repositroy.CustomersRepositroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@AllArgsConstructor
@EnableWebSecurity

public class SpringSecurityTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTestApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CustomersRepositroy customersRepositroy) {
        return args -> {
           customersRepositroy.save(
                    Customers.builder()
                           .email("oussmahamdane@gmail.com")
                           .password("{none}12345")
                           .Role("USER")
                           .build()
           );
           customersRepositroy.save(
                   Customers.builder()
                           .email("admin@gmail.com")
                           .password("{bcrypt}$2a$12$g3ltn405TzZI4llhztd.feboWcNyojAhGL4iVCvNElxExFIvl7Jci")
                           .Role("ADMIN")
                           .build()
           );
        };
    }
}
