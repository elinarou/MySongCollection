package summer23.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import summer23.backend.service.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		return http.authorizeHttpRequests(auth -> {
            // Permit all to css and h2-console
            auth.requestMatchers("/css/**").permitAll();
            auth.requestMatchers("/h2-console/**").permitAll();
            auth.requestMatchers("/h2-console").permitAll();
            // Only admin addsong and editsong
            auth.requestMatchers("/addsong/**").hasAuthority("ADMIN");
            auth.requestMatchers("/editsong/**").hasAuthority("ADMIN");
            // all http request will be authenticated
            auth.anyRequest().authenticated();
        })
                // H2-console configurations
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                // Successful login leads to songlist.html
                .formLogin(login -> login.defaultSuccessUrl("/artistlist", true))
                // Logout is permitted for all users
                .logout(logout -> logout.permitAll())
                // Building
                .httpBasic(Customizer.withDefaults()).build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}