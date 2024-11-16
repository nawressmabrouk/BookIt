package com.nawres.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.nawres.user.User;

public class ApplicationAuditing implements AuditorAware<Integer> {

    @Override

    // This class is implementing the AuditorAware<Integer> interface, which is
    // Spring Data interface that allows you to provide the current auditor (the
    // user performing an operation) for auditing purposes.
    public Optional<Integer> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
            return Optional.empty();
        }
        User userPrinicipal = (User) auth.getPrincipal();
        return Optional.ofNullable(userPrinicipal.getId());
    }

}