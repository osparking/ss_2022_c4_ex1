package space.bum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.httpBasic().and()
				// .authenticationManager(...) or Add an AuthenticationManager bean
				// .authenticationProvider(...) ; adds more to the provider collection
				.build();
	}
}
