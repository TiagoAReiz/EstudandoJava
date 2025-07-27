package group.Reiz.Project.Adapters;

import org.springframework.stereotype.Service;

import group.Reiz.Project.Core.Entities.userEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

@Service
public interface ItokenService  {
    public String generateToken(userEntity user);
    Boolean validateToken(String token);
    Claims extractClaims(String token) throws ExpiredJwtException ;
    public String getEmailFromToken(String token);
    public String getRoleFromToken(String token);
}
