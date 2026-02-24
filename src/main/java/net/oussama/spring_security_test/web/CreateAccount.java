package net.oussama.spring_security_test.web;

import lombok.AllArgsConstructor;
import net.oussama.spring_security_test.Entity.Customers;
import net.oussama.spring_security_test.Repositroy.CustomersRepositroy;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CreateAccount {
    private CustomersRepositroy customersRepositroy;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody Customers customers) {
        try{
             String hashpassword  = passwordEncoder.encode(customers.getPassword());
             customers.setPassword(hashpassword);
            customersRepositroy.save(customers);
          return new ResponseEntity<>("Account created successfully", HttpStatus.OK);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
