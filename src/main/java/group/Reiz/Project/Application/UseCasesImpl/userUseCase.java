package group.Reiz.Project.Application.UseCasesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import group.Reiz.Project.Adapters.*;
import group.Reiz.Project.Adapters.DTOs.loginDTO;
import group.Reiz.Project.Adapters.DTOs.loginResponseDTO;
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
    public loginResponseDTO userLogin(loginDTO user) {
        userEntity userDB = databaseService.getUserByEmail(user.getEmail());
        if (userDB != null && passwordEncoder.checkPassword(user.getPassword(), userDB.getPassword())) {
            Long id = userDB.getId();
            String token = tokenService.generateToken(id, userDB.getEmail());

            return new loginResponseDTO(token, "Login successful");
        } else {
            return new loginResponseDTO(null, "Invalid credentials");
        }
    }

}
