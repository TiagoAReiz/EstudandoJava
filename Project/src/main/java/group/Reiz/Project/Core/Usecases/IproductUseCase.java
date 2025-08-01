package group.Reiz.Project.Core.Usecases;

import java.util.List;

import org.springframework.http.ResponseEntity;

import group.Reiz.Project.Adapters.DTOs.Product.productDTO;
import group.Reiz.Project.Core.Entities.productEntity;
import group.Reiz.Project.Core.Entities.sellerEntity;

public interface IproductUseCase {
    public ResponseEntity<?> createProduct(productDTO product, sellerEntity seller);
    public List<productEntity> getAllProducts();

}
