package space.bum.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import space.bum.config.filters.ApiKeyFilter;

@Configuration
public class SecurityConfig {
	
	@Value("${the.key}")
	private String key;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.httpBasic()
				.and()
				.addFilterBefore(new ApiKeyFilter(key), BasicAuthenticationFilter.class)
				// .authenticationManager(...) or Add an AuthenticationManager bean
				// .authenticationProvider(...) ; adds more to the provider collection
				.build();
	}
}
