package group.Reiz.Project.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.Reiz.Project.Adapters.DTOs.Product.productDTO;
import group.Reiz.Project.Adapters.Security.ItokenService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import group.Reiz.Project.Application.UseCasesImpl.productUseCase;

import group.Reiz.Project.Core.Usecases.IuserUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/product")
public class productController {
    @Autowired
    private productUseCase productUseCase;
    @Autowired
    private IuserUseCase userUseCase;
    @Autowired
    private ItokenService tokenService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(HttpServletRequest request, @RequestBody productDTO product) {
        return productUseCase.createProduct(product, userUseCase.getSellerByUserId(tokenService.getIdFromToken(tokenService.getToken(request))));
    }
    @GetMapping("/all")
    public List<productDTO> getAllProducts() {
        return productUseCase.getAllProducts();
    }
    
    
}
