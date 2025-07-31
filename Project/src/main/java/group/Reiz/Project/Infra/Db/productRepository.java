package group.Reiz.Project.Infra.Db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import group.Reiz.Project.Core.Entities.productEntity;

public interface productRepository extends JpaRepository<productEntity, Long> {
    public List<productEntity> findAll();

    
}
