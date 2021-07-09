package com.prajwal.springsecurity.customfilter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationKey = request.getHeader("Authorization");

        CustomAuthentication auth = new CustomAuthentication(authorizationKey,null);

        Authentication result = authenticationManager.authenticate(auth);

        if(result.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(result);
            filterChain.doFilter(request,response);
        }

    }
}
