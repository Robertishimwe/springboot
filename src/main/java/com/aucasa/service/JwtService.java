package com.aucasa.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

private static final String SECRET = "6A586E327234753778214125442A472D4B6150645367566B5970337336763879";

	
	public String extractUsername(String token) {
		
		return extractClaim(token, Claims::getSubject);
	}
	
	
	public Date extractExpiration(String token) {
		
		return extractClaim(token, Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> ClaimsResolver) {
		
		final Claims claims= extractAllClaims(token);
		return ClaimsResolver.apply(claims);
	}
	public Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSigKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	
	public Boolean isTokenExpired(String token) {
		
		return extractExpiration(token).before(new Date());
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	public String generateToken(String userName) {
		
		Map<String, Object> claims = new HashMap<>();
		return createToke(claims, userName);
	}

	private String createToke(Map<String, Object> claims, String userName) {
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
				.signWith(getSigKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key getSigKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
