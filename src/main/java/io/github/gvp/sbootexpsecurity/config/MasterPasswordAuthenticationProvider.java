package io.github.gvp.sbootexpsecurity.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MasterPasswordAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var login = authentication.getName();
        var password = (String) authentication.getCredentials();

        String masterLogin = "master";
        String masterPassword = "321";

        if (masterLogin.equals(login) && masterPassword.equals(password)) {
            return new UsernamePasswordAuthenticationToken(
                    "Im Master",
                    null,
                    List.of(new SimpleGrantedAuthority("ADMIN"))
            );
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
