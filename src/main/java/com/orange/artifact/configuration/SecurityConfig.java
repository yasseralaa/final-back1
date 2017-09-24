package com.orange.artifact.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select email as username , password, 1 as enabled from user where email=?")
                .authoritiesByUsernameQuery(
                        "select user.email as username ," +
                                " role.role as role from user join role " +
                                "on user.role_id = role.id where email= ?"
                );
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .antMatchers("/users").permitAll()
//                .antMatchers("/notes/getnote").hasAnyRole("USER" , "ADMIN")
//                .antMatchers("/notes/**").hasRole("ADMIN")
//
//                .antMatchers("/weather/today").hasAnyRole("USER" , "ADMIN")
                .and()
                .csrf().disable().headers().frameOptions().disable();

    }

}