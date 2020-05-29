package org.openup.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
   private UserDetailsService userDetailsService;  // what we implements in the ClientService
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
    	
    	auth.userDetailsService(userDetailsService);
    }
   
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	  http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
    	http.cors();
        http.csrf().disable().authorizeRequests()
        .antMatchers("/**").permitAll()
                .antMatchers("/v1/artist/**, /v1/event/**, /v1/photos/**").permitAll()
                .antMatchers("/v1/admin/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                ;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

        
    @Override
    public void configure(WebSecurity web) throws Exception {  // to see swagger
        web
                .ignoring()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**","/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}