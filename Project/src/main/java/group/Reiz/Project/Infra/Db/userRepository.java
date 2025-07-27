package group.Reiz.Project.Infra.Db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import group.Reiz.Project.Core.Entities.userEntity;

@Service
public interface userRepository extends JpaRepository<userEntity, Long> {

    public userEntity findByEmail(String email);
    public List<userEntity> findAll();
}

