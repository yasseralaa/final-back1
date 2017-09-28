package com.orange.artifact.configuration;

import com.orange.artifact.errorhandling.EntityNotFoundException;
import com.orange.artifact.model.User;
import com.orange.artifact.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    UserServices userServices;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = null;
        try {
            user = userServices.findUser(name,password);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        if (user == null) {
            return null;
        } else {
            ArrayList<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(user.getRole().getRole()));
            return new UsernamePasswordAuthenticationToken(name, password,roles);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
