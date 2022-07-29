package com.webSecurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
@Component
public class JwtTokenHelper 
{
public static  final long JWT_TOKEN_VALIDITY=5 * 60 * 60;
private String secret="jwtTokenkey";
public String getUsernameFromToken(String token)
{
	return token;
	//return getClaimFromToken(token,Claims::getExpiration);
}

private String getClaimFromToken(String token, Object object)
{
	
	return null;
}

//validate token
    public Boolean validateToken(String token, UserDetails userDetails)
	{
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	private boolean isTokenExpired(String token)
	{
		return false;
	}
	
}