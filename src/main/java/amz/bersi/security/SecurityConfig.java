package amz.bersi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		/*****SANS HASH auth.inMemoryAuthentication().withUser("admin").password("{noop}666").roles("ADMIN", "USER");***/
		BCryptPasswordEncoder bcpe = getBPCE();
		auth.inMemoryAuthentication().withUser("admin").password(bcpe.encode("666")).roles("ADMIN", "USER");
		auth.inMemoryAuthentication().withUser("user").password(bcpe.encode("777")).roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.formLogin();
		http.authorizeRequests().antMatchers("/projectenvironment/quiz/addQuestion","/projectenvironment/quiz/addConseil").hasRole("ADMIN");
		/*http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/user/*").hasRole("USER");*/
	}

	@Bean
	BCryptPasswordEncoder getBPCE() {
		return new BCryptPasswordEncoder();
	}
}
