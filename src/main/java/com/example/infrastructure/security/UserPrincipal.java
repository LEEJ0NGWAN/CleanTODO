package com.example.infrastructure.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.infrastructure.jpa.user.UserEntity;

public class UserPrincipal implements UserDetails {

    private String username;
    private String password;

    private UserPrincipal() {}

    public static UserPrincipal fromThis(UserEntity user) {

        return Optional
        .ofNullable(user)
        .map(u -> {

            final UserPrincipal principal = new UserPrincipal();
            
            principal.username = u.getUsername();
            principal.password = u.getPassword();

            return principal;
        })
        .orElse(null);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        final Set<GrantedAuthority> set = new HashSet<>();

        set.add(new SimpleGrantedAuthority(Role.USER.getValue()));

        return set;
    }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() { return username; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
