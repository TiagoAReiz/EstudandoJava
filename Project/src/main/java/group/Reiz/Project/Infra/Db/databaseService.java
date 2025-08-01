package group.Reiz.Project.Infra.Db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import group.Reiz.Project.Adapters.DB.IdatabaseService;
import group.Reiz.Project.Core.Entities.*;
import java.util.List;

@Service
public class databaseService implements IdatabaseService {
    @Autowired
    private userRepository userManager;
    @Autowired
    private sellerRepository sellerManager;
    @Autowired
    private productRepository productManager;

    @Override
    public userEntity saveUser(userEntity user) {
        return userManager.save(user);
    }

    @Override
    public userEntity getUserByEmail(String email) {
        return userManager.findByEmail(email);
    }
    @Override
    public List<userEntity> getAllUsers() {
        return userManager.findAll();
    }
    @Override
    public Optional<userEntity> getUserById(Long id) {
        return userManager.findById(id);

    }
    @Override
    public sellerEntity saveSeller(sellerEntity seller) {
        return sellerManager.save(seller);
    }
    @Override
    public List<sellerEntity> getAllSellers() {
        return sellerManager.findAll();
    }
    @Override
    public sellerEntity getSellerByUserId(Long userId) {
        return sellerManager.getSellerByUserId(userId);
    }
    @Override
    public productEntity saveProduct(productEntity product) {
        return productManager.save(product);
    }
    @Override
    public List<productEntity> getAllProducts() {
        return productManager.findAll();
    }

}
