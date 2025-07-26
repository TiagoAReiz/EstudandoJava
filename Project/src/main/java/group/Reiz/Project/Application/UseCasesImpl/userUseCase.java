package group.Reiz.Project.Application.UseCasesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group.Reiz.Project.Adapters.*;
import group.Reiz.Project.Adapters.DTOs.loginDTO;
import group.Reiz.Project.Application.UseCasesImpl.Verificadores.userVerify;
import group.Reiz.Project.Core.Entities.userEntity;
import group.Reiz.Project.Core.Usecases.IuserUseCase;


@Service
public class userUseCase implements IuserUseCase {
    @Autowired
    private IdatabaseService databaseService;
    @Autowired
    private IpasswordEncoder passwordEncoder;
    @Autowired
    private ItokenService tokenService;
    @Autowired
    private userVerify userVerify;
    
    @Override
    public ResponseEntity<?> userCreate(userEntity user)
    {
        if (!userVerify.isValidEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", "Invalid email format"));
        }
        if (!userVerify.isValidPassword(user.getPassword())) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", "Password must be at least 8 characters long"));
        }
        user.setPassword(passwordEncoder.encodePassword(user.getPassword()));
        databaseService.saveUser(user);
        return ResponseEntity.ok(java.util.Map.of("message", "User created successfully"));
    }

    @Override
    public ResponseEntity<?> userLogin(loginDTO user) {
        userEntity userDB = databaseService.getUserByEmail(user.getEmail());
        if (userDB != null && passwordEncoder.checkPassword(user.getPassword(), userDB.getPassword())) {
            Long id = userDB.getId();
            String token = tokenService.generateToken(id, userDB.getEmail());
            // Retorne um JSON com o token
            return ResponseEntity.ok(java.util.Map.of("token", token));
        }
        return ResponseEntity.status(401).body(java.util.Map.of("error", "Invalid credentials"));
    }

}
