package group.Reiz.Project.Core.Usecases;

import org.springframework.http.ResponseEntity;

import group.Reiz.Project.Adapters.DTOs.productDTO;
import group.Reiz.Project.Core.Entities.sellerEntity;

public interface IproductUseCase {
    public ResponseEntity<?> createProduct(productDTO product, sellerEntity seller);


}
