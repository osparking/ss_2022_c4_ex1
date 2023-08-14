package space.bum.config.authentication;

import java.util.Collection;

import javax.security.auth.Subject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiKeyAuthentication implements Authentication{

	private final String key;
	private boolean authenticated;

	public String getKey() {
		return key;
	}
	
	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean authenticated) {
		// TODO Auto-generated method stub
		this.authenticated = authenticated;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean implies(Subject subject) {
		// TODO Auto-generated method stub
		return Authentication.super.implies(subject);
	}

}
