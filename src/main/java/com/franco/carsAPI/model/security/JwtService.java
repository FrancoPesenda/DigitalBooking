package com.franco.carsAPI.model.security;

import com.franco.carsAPI.service.serviceInterface.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService implements IJwtService {

    private String SECRET_KEY = "secret" ;

    public String extractUserName( String token ){
        return extractClaimUsername(token) ;
    }

    public Date extractExpiration( String token ){
        return extractClaimDate(token) ;
    }

    public Date extractClaimDate(String token ){
        Claims claims = extractAllClains(token) ;
        return claims.getExpiration() ;
    }

    public String extractClaimUsername( String token ){
        Claims claims = extractAllClains(token) ;
        return claims.getSubject() ;
    }

    private Claims extractAllClains( String token ){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody() ;
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    public String createToken(Map<String,Object> claims , String subject){
        Date now = new Date();
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(now.getTime() + 1200 * 60 * 1000))// 1200 minutos Creo, no se, al final no se si esta bien
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken( String token , UserDetails userDetails){
        final String username = extractUserName(token) ;
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token)) ;
    }

    public boolean isTokenExpired( String token ){
        return extractExpiration(token).before(new Date()) ;
    }

}
