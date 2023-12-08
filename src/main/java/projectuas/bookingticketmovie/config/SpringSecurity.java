package projectuas.bookingticketmovie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;

@Configuration
@EnableWebSecurity(debug = true)
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> {
                    request
                            .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/movie-details")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/register")).permitAll()
                            .requestMatchers("/users").hasRole("ADMIN")
                            .anyRequest().authenticated();
                })
                .formLogin(
                        (form) -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/users")
                                .permitAll()
                )
                .logout(
                        (logout) -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

}
