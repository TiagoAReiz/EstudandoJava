package group.Reiz.Project.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.Reiz.Project.Adapters.DTOs.createUserDTO;
import group.Reiz.Project.Adapters.DTOs.loginDTO;
import group.Reiz.Project.Core.Entities.userEntity;
import group.Reiz.Project.Core.Enums.Role;
import group.Reiz.Project.Core.Usecases.IuserUseCase;
import group.Reiz.Project.Adapters.ItokenService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private IuserUseCase userUseCase;

    @Autowired
    private ItokenService tokenService;

    @PostMapping("/create")
    public ResponseEntity<?> userCreate(@RequestBody createUserDTO user) {
        return userUseCase.userCreate(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody loginDTO request) {
        return userUseCase.userLogin(request);
    }

    @GetMapping("/admin")
    public List<userEntity> getAllUsers() {
        return userUseCase.getAllUsers();
    }

    @PatchMapping("/beseller")
    public ResponseEntity<?> beSeller(HttpServletRequest request) {
        return userUseCase.beseller(tokenService.getIdFromToken(tokenService.getToken(request)));
    }
}


