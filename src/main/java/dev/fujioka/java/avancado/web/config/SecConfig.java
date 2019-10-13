package dev.fujioka.java.avancado.web.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		    .authorizeRequests()
			.anyRequest().authenticated()
			.and().httpBasic();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
	    builder
	        .inMemoryAuthentication()
	        .withUser("teste").password("{noop}123")
	            .roles("USER");
	  }
}
