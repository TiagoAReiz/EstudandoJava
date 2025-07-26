package group.Reiz.Project.Adapters;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

@Service
public interface ItokenService  {
    String generateToken(Long id,String email);
    Boolean validateToken(String token);
    Claims extractClaims(String token) throws ExpiredJwtException ;
    public String getEmailFromToken(String token);
    public String getRoleFromToken(String token);
}
