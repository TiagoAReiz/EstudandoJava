package group.Reiz.Project.Infra.Db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import group.Reiz.Project.Core.Entities.sellerEntity;

@Service
public interface sellerRepository extends JpaRepository<sellerEntity, Long> {

   public List<sellerEntity> findAll();
   public sellerEntity getSellerByUserId(Long userId);
}

