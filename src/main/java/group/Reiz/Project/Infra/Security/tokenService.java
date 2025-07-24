package group.Reiz.Project.Infra.Security;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class tokenService {

    String secretKey = "secretkey";
    private long EXPIRATION_TIME = 1000000;
    public String generateToken(Long id, String email){
        return Jwts.builder()
                .setSubject(email)
                .claim("id", id)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }
    public String validateToken( String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    
}
