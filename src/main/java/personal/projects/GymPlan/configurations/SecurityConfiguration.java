package personal.projects.GymPlan.configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import personal.projects.GymPlan.servicies.UserCredentialsService;
import personal.projects.GymPlan.servicies.UserService;
import personal.projects.GymPlan.utils.UserCredentials;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserCredentialsService userCredentialsService;

    private final UserService userService;

    @Value("${security.option}")
    private String securityOption;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        switch (securityOption) {
            case "with-basic":
                configureBasic(http);
                break;
            case "with-form":
                configureFormBased(http);
                break;
            case "oauth2":
                configureOAuth2(http);
                break;
            default:
        }
    }

    private void configureOAuth2(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/home");
    }

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        List<UserCredentials> allCustomerCredentials = userCredentialsService.getCredentialsForAllUsers();

        final InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> authenticationConfig = auth
                .inMemoryAuthentication();

        allCustomerCredentials.forEach(credentials -> authenticationConfig.withUser(credentials.getUsername())
                .password(passwordEncoder().encode(credentials.getPassword())).authorities("ROLE_USER"));
    }

    protected void configureBasic(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    protected void configureFormBased(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .successForwardUrl("/login")
                .and()
                .logout().permitAll();
    }
}

