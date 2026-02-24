package net.oussama.spring_security_test.Repositroy;

import net.oussama.spring_security_test.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomersRepositroy extends JpaRepository<Customers,Long> {
    Optional<Customers> findByEmail(String email);
}
