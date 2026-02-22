package net.oussama.spring_security_test.controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsControlleur {
    @GetMapping("/cards")
    public String getcards() {
        return "cards FROM DB";
    }
}
