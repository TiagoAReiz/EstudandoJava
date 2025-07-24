package group.Reiz.Project.Application.UseCasesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import group.Reiz.Project.Adapters.*;

import group.Reiz.Project.Core.Entities.userEntity;
import group.Reiz.Project.Core.Usecases.IuserUseCase;

public class userUseCase implements IuserUseCase {
    @Autowired
    private IdatabaseService databaseService;
    @Autowired
    private IpasswordEncoder passwordEncoder;
    @Autowired
    private ItokenService tokenService;
    
    @Override
    public userEntity userCreate(userEntity user)
    {
        user.setPassword(passwordEncoder.encodePassword(user.getPassword()));

        return databaseService.saveUser(user);
    }

    @Override
    public ResponseEntity<String> userLogin(String email, String password) {
        userEntity user = databaseService.getUserByEmail(email);
        if (user != null && passwordEncoder.checkPassword(password, user.getPassword())) {
            Long id = user.getId();
            String token = tokenService.generateToken(id, email);

            return ResponseEntity.ok(token);
        }else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
    }

}
