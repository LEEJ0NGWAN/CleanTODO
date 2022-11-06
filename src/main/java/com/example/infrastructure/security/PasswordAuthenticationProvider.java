package com.example.infrastructure.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PasswordAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication)
    throws AuthenticationException {

        final UsernamePasswordAuthenticationToken token =
        (UsernamePasswordAuthenticationToken) authentication;

        final String username = token.getName();
        final String password = (String) token.getCredentials();

        final UserDetails userPrincipal =
        userDetailsService.loadUserByUsername(username);

        if (!passwordEncoder.matches(password, userPrincipal.getPassword()))
        throw new BadCredentialsException(username);

        return new UsernamePasswordAuthenticationToken
        (userPrincipal, password, userPrincipal.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
