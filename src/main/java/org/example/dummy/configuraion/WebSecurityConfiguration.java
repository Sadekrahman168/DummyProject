package org.example.dummy.configuraion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		
		//TODO: In memory Authentication too too BAD. 
      	auth.inMemoryAuthentication()
				.withUser("root").password("password").roles("USER")
                .and().withUser("admin").password("admin").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
	}
	
	
}
