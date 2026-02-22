package net.oussama.spring_security_test.controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceControlleur {
    @GetMapping("/mybalance")
    public String getBalance() {
        return "BALANCE FROM DB";
    }
}
