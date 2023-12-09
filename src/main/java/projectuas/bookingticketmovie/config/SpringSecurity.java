package projectuas.bookingticketmovie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import projectuas.bookingticketmovie.config.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public UserDetailsService getDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> {
                    request
                            .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/movie-details")).permitAll()
//                            .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
//                            .requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll()
//                            .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
//                            .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
//                            .requestMatchers(new AntPathRequestMatcher("/register")).permitAll()
//                            .requestMatchers(new AntPathRequestMatcher("/dashboard")).permitAll()
                            .requestMatchers("/users").hasRole("ADMIN")
                            .anyRequest().permitAll();
                })
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/userLogin")
                                .usernameParameter("email")
                                .defaultSuccessUrl("/dashboard")
                                .failureUrl("/login?loginError=true")
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login?logoutSuccess=true")
                                .deleteCookies("JSESSIONID")
                                .permitAll()
                )
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login?loginRequired=true"))
                );
        return http.build();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(final AuthenticationConfiguration authenticationConfiguration)
//        throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(getDetailsService())
//                .passwordEncoder(passwordEncoder());
//    }
}
