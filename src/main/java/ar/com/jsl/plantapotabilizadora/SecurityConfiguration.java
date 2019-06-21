package ar.com.jsl.plantapotabilizadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ar.com.jsl.plantapotabilizadora.business.IAuthTokenBusiness;
import ar.com.jsl.plantapotabilizadora.model.persistence.UsuarioRepository;
import ar.com.jsl.plantapotabilizadora.web.Constantes;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private IAuthTokenBusiness authTokenService;
	@Autowired
	private UsuarioRepository usuariosDAO;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] resources = new String[] { "/", "/index.html", "/favicon.png", "/app.js", "/config/**",
				"/directives/**", "/controllers/**", "/img/**", "/lib/**", "/services/**", "/views/**",
				Constantes.URL_DENY, "/webjars/**", "/swagger-resources/**", "/swagger-ui.html",
				Constantes.URL_CORE + "/version" };
		http.authorizeRequests().antMatchers(resources).permitAll();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/dologin*").permitAll().anyRequest().authenticated();
		http.formLogin().loginPage(Constantes.URL_DENY).loginProcessingUrl("/dologin")
				.successForwardUrl(Constantes.URL_LOGINOK).failureForwardUrl(Constantes.URL_DENY);
		http.logout().deleteCookies("JSESSIONID", "rm", "SESSION");
		http.httpBasic();
		http.addFilterAfter(new CustomTokenAuthenticationFilter(authTokenService, usuariosDAO),
				UsernamePasswordAuthenticationFilter.class);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
}