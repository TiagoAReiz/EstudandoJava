package group.Reiz.Project.Application.UseCasesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group.Reiz.Project.Adapters.DB.IdatabaseService;
import group.Reiz.Project.Adapters.DTOs.Product.productDTO;
import group.Reiz.Project.Core.Entities.productEntity;
import group.Reiz.Project.Core.Entities.sellerEntity;
import group.Reiz.Project.Core.Usecases.IproductUseCase;

@Service
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
        databaseService.saveProduct(newProduct);

        return ResponseEntity.ok(java.util.Map.of("message", "Product created successfully"));
    }
    @Override
    public List<productDTO> getAllProducts() {
        List<productEntity> products = databaseService.getAllProducts();
        return products.stream().map(this::convertToDTO).toList();
    }

    private productDTO convertToDTO(productEntity product) {
        productDTO dto = new productDTO();
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategory(product.getCategory());
        dto.setStock(product.getStock());
        dto.setImageUrl(product.getImageUrl());
        return dto;
    }

    }


