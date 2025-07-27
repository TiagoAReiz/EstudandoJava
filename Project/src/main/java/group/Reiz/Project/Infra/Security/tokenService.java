package group.Reiz.Project.Infra.Security;

import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Service;

import group.Reiz.Project.Adapters.ItokenService;
import group.Reiz.Project.Core.Entities.userEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

@Service
public class tokenService implements ItokenService {

    @Value("${SECRET_KEY}")
    private String secretKey;

    private long EXPIRATION_TIME = 1000000;

    private byte[] getKeyBytes() {
        return Base64.getDecoder().decode(secretKey);
    }

    @Override
     public String generateToken(userEntity user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .claim("role", user.getRole().name()) 
                .setIssuer("Reiz Project")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, getKeyBytes())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    @Override
    public Boolean validateToken(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public Claims extractClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(getKeyBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public String getEmailFromToken(String token) {
        return extractClaims(token).getSubject();
    }

    @Override
    public String getRoleFromToken(String token) {
        return extractClaims(token).get("role", String.class);
    }
}
