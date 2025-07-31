package group.Reiz.Project.Core.Usecases;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import group.Reiz.Project.Adapters.DTOs.*;

import group.Reiz.Project.Core.Entities.*;



public interface IuserUseCase {
    public ResponseEntity<?> userCreate(createUserDTO user);
    public ResponseEntity<?> userLogin(loginDTO user);
    public List<userEntity> getAllUsers();
    public Optional<userEntity> getUserById(Long id);
    public ResponseEntity<?> beseller(userEntity user, sellerDTO seller);
    public sellerEntity getSellerByUserId(Long userId);
}
