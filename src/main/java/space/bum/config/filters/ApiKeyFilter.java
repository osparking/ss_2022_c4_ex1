package space.bum.config.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.AllArgsConstructor;

// 이것을 어디에도 두고 싶진 않다.
@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter{

	@Value("${the.key}")
	private final String key;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		filterChain.doFilter(request, response); // 언젠가 호출해야...
	}

}
