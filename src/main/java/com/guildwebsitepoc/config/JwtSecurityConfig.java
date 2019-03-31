package com.guildwebsitepoc.config;

import com.guildwebsitepoc.security.JwtAuthenticationEntryPoint;
import com.guildwebsitepoc.security.JwtAuthenticationProvider;
import com.guildwebsitepoc.security.JwtAuthenticationTokenFilter;
import com.guildwebsitepoc.security.JwtSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider));
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {

        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception {

        http
                .antMatcher("/guildwebsitepoc/api/AccountsService/**")
                .authorizeRequests()
                .antMatchers("/guildwebsitepoc/api/AccountsService/**").authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.headers().cacheControl();
    }
}
