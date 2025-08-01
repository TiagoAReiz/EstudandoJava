package group.Reiz.Project.Application.UseCasesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import group.Reiz.Project.Adapters.IdatabaseService;
import group.Reiz.Project.Adapters.DTOs.productDTO;
import group.Reiz.Project.Core.Entities.productEntity;
import group.Reiz.Project.Core.Entities.sellerEntity;
import group.Reiz.Project.Core.Usecases.IproductUseCase;


public class productUseCase implements IproductUseCase {
   @Autowired
    private IdatabaseService databaseService;
    @Override
    public ResponseEntity<?> createProduct(productDTO product, sellerEntity seller) {
        productEntity newProduct = new productEntity();
        newProduct.setName(product.getName());  
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setSeller(seller);
        newProduct.setCategory(product.getCategory());
        newProduct.setStock(product.getStock());
        newProduct.setImageUrl(product.getImageUrl());


        return ResponseEntity.ok(java.util.Map.of("message", "Product created successfully"));
    }

    public List<productEntity> getAllProducts() {
        return databaseService.getAllProducts();
    }
    

    }


