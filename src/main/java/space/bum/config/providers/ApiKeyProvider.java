package space.bum.config.providers;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import lombok.AllArgsConstructor;
import space.bum.config.authentication.ApiKeyAuthentication;

@AllArgsConstructor
public class ApiKeyProvider implements AuthenticationProvider{

	private final String key;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		var auth = (ApiKeyAuthentication) authentication;
		if (key.equals(auth.getKey())) {
			auth.setAuthenticated(true);
			return auth;
		}
		throw new BadCredentialsException("헤더 인증 키 오류");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return ApiKeyAuthentication.class.equals(authentication);
	}

}
