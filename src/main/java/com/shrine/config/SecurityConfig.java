package com.shrine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.shrine.entity.StaffAccountEntity;
import com.shrine.model.LoginUser;
import com.shrine.repository.StaffAccountRepository;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,StaffAccountRepository staffAccountRepository) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/",
                    "/login",
                    "/reservations/new",
                    "/reservations",
                    "/api/postal-code",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(loginSuccessHandler(staffAccountRepository))
                .failureUrl("/login?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(StaffAccountRepository staffAccountRepository) {
        return (request, response, authentication) -> {
            String username = authentication.getName();
    		
    		StaffAccountEntity staffAccount = staffAccountRepository.findByUsername(username)
                 .orElseThrow();

         String role = staffAccount.getRole();

//         staffNameをhtmlに表示するためにLoginUserクラスを作成し、セッションに保存
         LoginUser loginUser = new LoginUser(
                 staffAccount.getUsername(),
                 staffAccount.getStaffName(),
                 role
         );

         request.getSession().setAttribute("loginUser", loginUser);

         if ("ADMIN".equals(role)) {
                response.sendRedirect("/admin");
            } else {
                response.sendRedirect("/staff");
            }
        };
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    			return new BCryptPasswordEncoder();
    }
}