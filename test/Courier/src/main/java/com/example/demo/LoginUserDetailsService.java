package com.example.demo;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    private final LoginUserRepository loginUserRepository;

    public LoginUserDetailsService(LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        Optional<LoginUser> loginUserOptional = loginUserRepository.findByName(user_name);
        return loginUserOptional.map(loginUser -> new LoginUserDetails(loginUser))
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
    }
}