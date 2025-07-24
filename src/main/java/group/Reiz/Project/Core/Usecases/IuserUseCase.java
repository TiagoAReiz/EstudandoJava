package group.Reiz.Project.Core.Usecases;


import group.Reiz.Project.Adapters.DTOs.loginDTO;
import group.Reiz.Project.Adapters.DTOs.loginResponseDTO;
import group.Reiz.Project.Core.Entities.userEntity;

public interface IuserUseCase {
    public userEntity userCreate(userEntity user);
    public loginResponseDTO userLogin(loginDTO user);
}
