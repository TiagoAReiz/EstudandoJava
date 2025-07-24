package group.Reiz.Project.Adapters;

import group.Reiz.Project.Core.Entities.userEntity;

public interface IdatabaseService {

    public userEntity saveUser(userEntity user);
    public userEntity getUserByEmail(String email);
 }
