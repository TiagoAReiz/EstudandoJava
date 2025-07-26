package group.Reiz.Project.Core.Usecases;


import org.springframework.http.ResponseEntity;

import group.Reiz.Project.Adapters.DTOs.loginDTO;

import group.Reiz.Project.Core.Entities.userEntity;

public interface IuserUseCase {
    public String userCreate(userEntity user);
    public ResponseEntity<String> userLogin(loginDTO user);
}
