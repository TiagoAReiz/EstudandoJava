package group.Reiz.Project.Adapters;

import org.springframework.stereotype.Service;

import group.Reiz.Project.Core.Entities.userEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;

@Service
public interface ItokenService  {
    public String generateToken(userEntity user);
    Boolean validateToken(String token);
    Claims extractClaims(String token) throws ExpiredJwtException ;
    public Long getIdFromToken(String token);
    public String getEmailFromToken(String token);
    public String getRoleFromToken(String token);
    public String getToken(HttpServletRequest request);
}
