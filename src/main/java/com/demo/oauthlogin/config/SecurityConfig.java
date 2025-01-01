package com.demo.oauthlogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpMethod;
import org.modelmapper.ModelMapper;

@Configuration
public class SecurityConfig {


    private String publicUrls[] = new String[]
    {
         "login.html", "signup.html","/login",
         "/css/**", "/images/**", "/js/**","/signup","/register",
         "/oauth2/**", "/oauth2/authorization/google","/logout-confirm", "/logout-success"
    };
    @Bean
    public PasswordEncoder getPasswordEncoder() {
          return new BCryptPasswordEncoder();
     }
    @Bean
     public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(getPasswordEncoder());

         return provider;
    }
    @Bean
    public ModelMapper modelMapper() {
       return new ModelMapper();
    }
   @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

             System.out.println("security process initialized");
             http.
                     csrf( csrf -> csrf.disable())
                     .authorizeHttpRequests()
                     .requestMatchers(publicUrls).permitAll()
                     .anyRequest().authenticated();
            
             http.formLogin().loginPage("/login")
                    .loginProcessingUrl("/login")
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/home",true)
                    .permitAll();

              http.logout().logoutUrl("/logout")
                    .logoutSuccessUrl("/logout-success")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID");


             http.oauth2Login().loginPage("/login")
                     .loginProcessingUrl("/login/oauth2/authorization")
                     .defaultSuccessUrl("/home",true)
                     .permitAll();

             return http.build();
    }

}