package com.codecool.elproyectegrande1.security;

import com.codecool.marwin1991.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //TODO

        filterChain.doFilter(request, response);
    }

    private String getJwtFromReqest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token.startsWith("Bearer ")){
            return token.substring(7);
        }
        return "";
    }
}
