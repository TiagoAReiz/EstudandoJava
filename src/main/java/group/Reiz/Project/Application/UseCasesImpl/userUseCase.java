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
    public String userCreate(userEntity user)
    {
        if (!userVerify.isValidEmail(user.getEmail())) {
            return "Invalid email format";
        }
        if (!userVerify.isValidPassword(user.getPassword())) {
            return "Password must be at least 8 characters long";
        }
        user.setPassword(passwordEncoder.encodePassword(user.getPassword()));
        databaseService.saveUser(user);
        return "User created successfully";
    }

    @Override
    public ResponseEntity<String> userLogin(loginDTO user) {
        userEntity userDB = databaseService.getUserByEmail(user.getEmail());
        if (userDB != null && passwordEncoder.checkPassword(user.getPassword(), userDB.getPassword())) {
            Long id = userDB.getId();
            String token = tokenService.generateToken(id, userDB.getEmail());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

}
