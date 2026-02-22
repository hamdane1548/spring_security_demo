package net.oussama.spring_security_test.controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactControlleur {
    @GetMapping("/contact")
    public String getaccont() {
        return "account FROM DB";
    }
}
