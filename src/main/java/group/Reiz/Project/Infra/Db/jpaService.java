package group.Reiz.Project.Infra.Db;

import org.springframework.data.jpa.repository.JpaRepository;

import group.Reiz.Project.Core.Entities.userEntity;

public interface jpaService extends JpaRepository<userEntity, Long> {

    userEntity findByEmail(String email);

}

