package group.Reiz.Project.Infra.Db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import group.Reiz.Project.Adapters.IdatabaseService;

import group.Reiz.Project.Core.Entities.userEntity;
import java.util.List;

@Service
public class databaseService implements IdatabaseService {
    @Autowired
    private jpaService userManager;

    @Override
    public userEntity saveUser(userEntity user) {
        return userManager.save(user);
    }

    @Override
    public userEntity getUserByEmail(String email) {
        return userManager.findByEmail(email);
    }
    @Override
    public List<userEntity> getAllUsers() {
        return userManager.findAll();
    }
    @Override
    public Optional<userEntity> getUserById(Long id) {
        return userManager.findById(id);
    }

}
