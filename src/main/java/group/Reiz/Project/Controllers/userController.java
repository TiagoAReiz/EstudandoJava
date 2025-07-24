package group.Reiz.Project.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.Reiz.Project.Adapters.DTOs.loginDTO;
import group.Reiz.Project.Adapters.DTOs.loginResponseDTO;
import group.Reiz.Project.Core.Entities.userEntity;
import group.Reiz.Project.Core.Usecases.IuserUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private IuserUseCase userUseCase;
    
    @PostMapping("/create")
    public userEntity userCreate(@RequestBody userEntity user) {
        return userUseCase.userCreate(user);
    }
    @PostMapping("/login")
    public loginResponseDTO userLogin(@RequestBody loginDTO user) {
        return userUseCase.userLogin(user);
    }
}
