package uk.co.mulecode.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(HttpSecurity http) throws Exception {
    //@formatter:off
    http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .antMatchers("/welcome/**").permitAll()
            .antMatchers("/public/**").permitAll()
            .antMatchers("/static", "/static/**", "/static**").permitAll()
            .antMatchers("/webjars/**").permitAll()
            .antMatchers("/actuator/health", "/actuator/prometheus").permitAll()
            .antMatchers("/api/**").authenticated()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
            .loginPage("/login")
        .and()
          .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");
    //@formatter:on
  }

}
