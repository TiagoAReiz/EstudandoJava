package group.Reiz.Project.Core.Usecases;

import org.springframework.http.ResponseEntity;

import group.Reiz.Project.Core.Entities.userEntity;

public interface IuserUseCase {
    public userEntity userCreate(userEntity user);
    public ResponseEntity<String> userLogin(String email, String password);
    public userEntity userLogin(userEntity user);
}
