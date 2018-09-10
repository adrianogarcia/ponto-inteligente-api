package br.com.memory.pontointeligente.api.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.memory.pontointeligente.api.security.JwtAuthenticationEntryPoint;
import br.com.memory.pontointeligente.api.security.filter.JwtAuthenticationTokenFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private JwtAuthenticationEntryPoint unathorizedHandler;

	@Autowired
	@Qualifier("jwtUserDetailsService")
	private UserDetailsService userDetailsService;
	
	
//	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	{
		authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean (name = "authenticationManagerBean") 
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Bean (name = "jwtUserDetailsService")
	@Override
	public UserDetailsService userDetailsServiceBean()
	{
		return super.userDetailsService();
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception
	{
		return new JwtAuthenticationTokenFilter();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(unathorizedHandler).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/auth/**", "/api/cadastrar-pf").permitAll().anyRequest().authenticated();

		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
		http.headers().cacheControl();
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception
//	{
//		web.ignoring().antMatchers("/**");
//		super.configure(web);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception
//	{
//		http.authorizeRequests().antMatchers("/**").permitAll()
//		
//		;
//		super.configure(http);
//	}
//	
}
