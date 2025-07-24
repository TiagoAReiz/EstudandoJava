package group.Reiz.Project.Infra.Db;

import org.springframework.beans.factory.annotation.Autowired;
import group.Reiz.Project.Adapters.IdatabaseService;

import group.Reiz.Project.Core.Entities.userEntity;

public class databaseService implements IdatabaseService {
    @Autowired
    private jpaService userManager;

    public userEntity saveUser(userEntity user) {
        return userManager.save(user);
    }

    @Override
    public userEntity getUserByEmail(String email) {
        return userManager.findByEmail(email);
    }

}
