package com.codingParkFun.rmsbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

//@Configuration
//@Order(1)
public class AdminRMSSecurityConfig {
/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	}

	public DigestAuthenticationFilter getDigestAuthFilter() throws Exception {
		DigestAuthenticationFilter filter = new DigestAuthenticationFilter();

		filter.setUserDetailsService(userDetailsServiceBean());
		filter.setAuthenticationEntryPoint((DigestAuthenticationEntryPoint) getDigestEntryPoint());

		return filter;
	}

	private AuthenticationEntryPoint getDigestEntryPoint() {
		DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();

		entryPoint.setRealmName("admin-digest-realm");
		entryPoint.setKey("fjk1232+_");

		return entryPoint;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("password1").roles("USER").and().withUser("user2")
				.password("password2").roles("ADMIN");
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	*/
}
