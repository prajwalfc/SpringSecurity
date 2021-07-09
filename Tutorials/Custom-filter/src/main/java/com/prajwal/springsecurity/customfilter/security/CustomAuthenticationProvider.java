package com.prajwal.springsecurity.customfilter.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String requestKey = authentication.getName();
        if(requestKey.equals(key)) {
            Authentication a = new CustomAuthentication(null, null, null);
            return a;
        }else{
            throw new BadCredentialsException("Bad Credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authType) {
        return CustomAuthentication.class.equals(authType);
    }
}
