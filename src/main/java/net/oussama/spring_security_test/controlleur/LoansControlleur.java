package net.oussama.spring_security_test.controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansControlleur {
    @GetMapping("/loans")
    public String getloans() {
        return "loans FROM DB";
    }
}
