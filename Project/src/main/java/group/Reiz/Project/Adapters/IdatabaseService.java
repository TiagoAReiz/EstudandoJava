package group.Reiz.Project.Adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import group.Reiz.Project.Core.Entities.userEntity;

@Service
public interface IdatabaseService {

    public userEntity saveUser(userEntity user);
    public userEntity getUserByEmail(String email);
    public List<userEntity> getAllUsers();
 }
