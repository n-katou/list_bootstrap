// package com.naoto.portfolio.app.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import lombok.RequiredArgsConstructor;

// @Configuration
// @EnableWebSecurity
// @RequiredArgsConstructor

// public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

//     private final UserDetailsService uds;

//     protected void configure(HttpSecurity http) throws Exception {
        
//         http
//             .authorizeRequests().antMatchers("/users").permitAll()
//             .antMatchers("/admin").hasRole("ADMIN")
//             .antMatchers("/user").hasRole("USER")
//             .anyRequest().authenticated();

//         http
//             .formLogin()
//             .loginProcessingUrl("/")
//             .loginPage("/")
//             .failureUrl("/")
//             .usernameParameter("username")
//             .passwordParameter("password")
//             .defaultSuccessUrl("/common",true);

//         http
//             .logout()
//             .logoutUrl("/logout")
//             .logoutSuccessUrl("/");
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(uds).passwordEncoder(passwordEncoder());
//     }
    
// }
