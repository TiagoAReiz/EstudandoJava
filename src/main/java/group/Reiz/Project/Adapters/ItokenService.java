package group.Reiz.Project.Adapters;

public interface ItokenService {
    String generateToken(Long id,String email);
    String validateToken(String token);
}
