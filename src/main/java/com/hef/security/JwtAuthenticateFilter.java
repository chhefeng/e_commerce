package com.hef.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class JwtAuthenticateFilter extends UsernamePasswordAuthenticationFilter {

    private static final String strKey = "iPrBkYvpb3ddf2FtGEZ-GzMTQKhrUzJzyNM6RKpWWWW";
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticateFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/api/token");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationFilter =
                new UsernamePasswordAuthenticationToken(username, password);

        return this.authenticationManager.authenticate(usernamePasswordAuthenticationFilter);

    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        Key key = Keys.hmacShaKeyFor(strKey.getBytes());

        String token = Jwts.builder()
                .setHeaderParam("TYP", "JWT")
                .setIssuer("setIssuer")
                .setAudience("setAudience")
                .setExpiration(new Date(System.currentTimeMillis() + 10000))
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setIssuer("www.pan.com")
                .claim("rol", roles)
                .signWith(key).compact();

        response.setHeader("Authorization", "Bearer" + token);


    }
}
