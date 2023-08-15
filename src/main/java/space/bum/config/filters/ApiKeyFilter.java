package space.bum.config.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.AllArgsConstructor;
import space.bum.config.authentication.ApiKeyAuthentication;
import space.bum.config.managers.CustomAuthenticationManager;

// 이것을 어디에도 두고 싶진 않다.
@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

	@Value("${the.key}")
	private final String key;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		var manager = new CustomAuthenticationManager();
		var auth = new ApiKeyAuthentication(key);

		try {
			var a = manager.authenticate(auth);
			if (a.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(a);
				filterChain.doFilter(request, response); // 언젠가 호출해야...
			} else {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		} catch (AuthenticationException e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

}
