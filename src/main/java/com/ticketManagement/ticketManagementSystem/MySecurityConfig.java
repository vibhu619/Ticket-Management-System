package com.ticketManagement.ticketManagementSystem;

import com.ticketManagement.ticketManagementSystem.Service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Autowired
    CustomerUserDetailsService customUserDetailsService;

    //Basic auth config
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((authz) ->
                        authz.requestMatchers(antMatcher("/movies/**")).permitAll()  //it will not apply security  on movie controller endpoints and allow all
                        .requestMatchers(antMatcher(HttpMethod.POST, "/reservation/**"))   //it will not apply security  on reservation controller endpoints having method post and allow only admin users only
                                .hasRole("ADMIN")
                        .requestMatchers(antMatcher("/schedule/**")).hasRole("NORMAL")
                        .requestMatchers(antMatcher(("/user/**"))).permitAll()
                        .anyRequest()            //if no ant matcher is used than anyRequest will apply security to all the incoming request url
                        .authenticated()
                )
                //.httpBasic(withDefaults()); //basic auth
                .formLogin();   //form based login
        return http.build();
    }


    //customizing username and password ---by using In-Memory Authentication
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("vibhu")
//                .password("abc")
//                .roles("ADMIN")
//                .build();
//        //User1 is using default password encoder
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("akash")
//                //encoding password---for production level code
//                //.password(this.passwordEncoder().encode("xyz"))
//                .password("xyz")
//                .roles("NORMAL")
//                .build();
//        //User2 is using Bcrypt Password encoder
//        return new InMemoryUserDetailsManager(user1,user2);
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    //password bcrypt encoder
    @Bean
        public  static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

}
