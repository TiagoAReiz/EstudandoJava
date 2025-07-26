package group.Reiz.Project.Infra.Db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import group.Reiz.Project.Core.Entities.userEntity;

@Service
public interface jpaService extends JpaRepository<userEntity, Long> {

    userEntity findByEmail(String email);

}

