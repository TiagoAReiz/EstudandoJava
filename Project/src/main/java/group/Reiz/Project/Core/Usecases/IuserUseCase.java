package group.Reiz.Project.Core.Usecases;


import java.util.List;

import org.springframework.http.ResponseEntity;

import group.Reiz.Project.Adapters.DTOs.loginDTO;

import group.Reiz.Project.Core.Entities.userEntity;

public interface IuserUseCase {
    public ResponseEntity<?> userCreate(userEntity user);
    public ResponseEntity<?> userLogin(loginDTO user);
    public List<userEntity> getAllUsers();
}
