package com.taekwondo.config;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.taekwondo.service.UsuarioService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	
	@Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "jesus_esta_pasando_por_aqui_y_cuando_el_pasa";
	
	@Value("${security.jwt.token.expire-length:6000000}")
	private long validityInMilliseconds = 6000000;
	
	@Autowired
	private UsuarioService uSrv;
	
	@PostConstruct
	protected void init() {
		this.secretKey = Base64.getEncoder().encodeToString(this.secretKey.
				getBytes());
		
	}
	
	public String createToken(String userName, String tipo_usuario) {
		Claims claims = Jwts.claims().setSubject(userName);
		claims.put("roles", tipo_usuario);
		Date now = new Date();
		Date validity = new Date(now.getTime() + this.validityInMilliseconds);
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(validity)
				.signWith(SignatureAlgorithm.HS256, this.secretKey)
				.compact();	
	}
	
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(this.secretKey)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = this.uSrv
				.loadUserByUsername(this.getUsername(token));
		return new UsernamePasswordAuthenticationToken(
				userDetails, "", userDetails.getAuthorities());
	}
	
	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
	
	public boolean validateToken(String token) {
		Jws<Claims> claims = Jwts.parser().setSigningKey(this.secretKey)
					.parseClaimsJws(token);
		if (claims.getBody().getExpiration().before(new Date())) {
			return false;
		}
		return true;
	}
	
	
}
