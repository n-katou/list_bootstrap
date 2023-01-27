package com.naoto.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

    http.formLogin(login -> login                                   //フォーム認証の設定記述開始
        .loginProcessingUrl("/user/login")      //ユーザー名、パスワードの送信先URL
        .loginPage("/user/login")                        //ログイン画面のURL
        .usernameParameter("username")           //ユーザ名のリクエストパラメータ名を設定
        .passwordParameter("password")           //パスワードのリクエストパラメータ名を設定
        .defaultSuccessUrl("/todos")  //ログイン成功後のリダイレクト先URL
        .failureUrl("/login?error")       //ログイン失敗後のリダイレクト先URL
        .permitAll()                                                //ログイン画面は未ログインでもアクセス可能
    ).logout(logout -> logout                                       //ログアウトの設定記述開始
      .logoutUrl("/logout")                         //ログアウト画面のURL
      .logoutSuccessUrl("/user/login")            //ログアウト成功後のリダイレクト先URL
    ).authorizeHttpRequests(authz -> authz                          //URLごとの認可設定記述開始
      .mvcMatchers("/user/new").permitAll()         //ユーザー登録画面は未ログインでもアクセス可能
      .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
      .permitAll()                                                  //cssなどはログインなしでもアクセス可能
      .anyRequest().authenticated()
    );

    return http.build();
  }
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }

  //パスワードをハッシュ化
  @Bean
  public static PasswordEncoder PasswordEncoder(){
    return new BCryptPasswordEncoder();
  }

  // public static void main(String[] args) {
  // System.out.println(PasswordEncoder().encode("123456"));
  // }
}
