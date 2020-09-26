package com.eval.coronakit.config;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder builder = User.builder().passwordEncoder(new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t;
			}
		});
		auth.inMemoryAuthentication().withUser(builder.username("Admin").password("admin").roles("ADMIN"))
				.withUser(builder.username("First").password("abc").roles("USER"))
				.withUser(builder.username("Second").password("abc").roles("USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/Admin/**").hasAuthority("ADMIN").antMatchers("/First/**")
				.hasAuthority("USER").antMatchers("/Second/**").hasAuthority("USER");

		http.formLogin().loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/home")
				.usernameParameter("unm").passwordParameter("pwd");
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");

		http.exceptionHandling().accessDeniedPage("/pages/accessDeniedPage.jsp");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
