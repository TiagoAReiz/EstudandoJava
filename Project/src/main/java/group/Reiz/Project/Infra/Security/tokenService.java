package group.Reiz.Project.Infra.Security;

import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Service;

import group.Reiz.Project.Adapters.ItokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class tokenService implements ItokenService {

    String secretKey = "ELQfEzwve5Houvc3r2Gc64xtOQU2evIjjfGbdzc9G7Y=";
     private byte[] keyBytes = Base64.getDecoder().decode(secretKey);
    private long EXPIRATION_TIME = 1000000;
    @Override
    public String generateToken(Long id, String email){
        return Jwts.builder()
                .setSubject(email)
                .claim("id", id)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, keyBytes)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    @Override
    public Boolean validateToken( String token) {
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
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public String getEmailFromToken(String token) {
        return extractClaims(token).getSubject();
    }
    
}
