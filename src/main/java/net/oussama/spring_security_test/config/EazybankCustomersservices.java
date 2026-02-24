package net.oussama.spring_security_test.config;

import lombok.AllArgsConstructor;
import net.oussama.spring_security_test.Entity.Customers;
import net.oussama.spring_security_test.Repositroy.CustomersRepositroy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class EazybankCustomersservices implements UserDetailsService {
    private CustomersRepositroy customersRepositroy;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customers customers = customersRepositroy.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(email)
        );
        List<GrantedAuthority>  grantedAuthorities = List.of(new SimpleGrantedAuthority(customers.getRole()));
        return new User(customers.getEmail(), customers.getPassword(),grantedAuthorities);
    }
}
