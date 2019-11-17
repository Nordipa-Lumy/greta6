package amz.bersi.security;

import javax.sql.DataSource;

import org.apache.tomcat.websocket.BackgroundProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//@Autowired
	//BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	PasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public PasswordEncoder getBPCE() {
	    return new BCryptPasswordEncoder();
	}

	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		/*****SANS HASH auth.inMemoryAuthentication().withUser("admin").password("{noop}666").roles("ADMIN", "USER");***/
		/*
	 	BCryptPasswordEncoder bcpe = getBPCE();
		auth.inMemoryAuthentication().withUser("admin").password(bcpe.encode("666")).roles("ADMIN", "USER");
		auth.inMemoryAuthentication().withUser("user").password(bcpe.encode("777")).roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
		*/
		PasswordEncoder bcpe = getBPCE();
		
		System.out.println("666**********" +bcpe.encode("666"));
		//System.out.println("777**********" +bcpe.encode("999"));
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, password as credentials, active from user where username = ?" )
			.authoritiesByUsernameQuery("select username as principal, role as role from user_role where username = ?")
			.rolePrefix("ROLE_")
			.passwordEncoder(bcpe);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.formLogin();
		http.authorizeRequests().antMatchers("/projectenvironment/quiz/addQuestion","/projectenvironment/quiz/addConseil").hasRole("ADMIN");
		/*http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/user/*").hasRole("USER");*/
		http.exceptionHandling().accessDeniedPage("/403");
	}

		
	//@Bean
	//BCryptPasswordEncoder getBPCE() {
	//	return new BCryptPasswordEncoder();
	//}
}
