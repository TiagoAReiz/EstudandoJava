package group.Reiz.Project.Adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import group.Reiz.Project.Core.Entities.*;



@Service
public interface IdatabaseService {

    public userEntity saveUser(userEntity user);
    public userEntity getUserByEmail(String email);
    public List<userEntity> getAllUsers();
    public Optional<userEntity> getUserById(Long id);
    public sellerEntity saveSeller(sellerEntity seller);
    public List<sellerEntity> getAllSellers();
 }
