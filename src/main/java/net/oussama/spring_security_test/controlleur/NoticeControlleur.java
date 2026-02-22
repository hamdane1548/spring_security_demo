package net.oussama.spring_security_test.controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeControlleur {
    @GetMapping("/notice")
    public String getnotice() {
        return "notice FROM DB";
    }
}
