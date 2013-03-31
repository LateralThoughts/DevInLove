package com.lateralthoughts.devinlove.service;

import com.lateralthoughts.devinlove.domain.Person;
import com.lateralthoughts.devinlove.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private PersonRepository persons;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person principal = persons.findByLogin(username);
        if (principal == null) {
            throw new UsernameNotFoundException("not found");
        }
        return principal;
    }
}
