/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller;

import java.util.List;
import rs.ac.bg.fon.ps.domain.Manufacturer;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.User;
import rs.ac.bg.fon.ps.repository.RepositoryManufacturer;
import rs.ac.bg.fon.ps.repository.RepositoryProduct;
import rs.ac.bg.fon.ps.repository.RepositoryUser;

/**
 *
 * @author Ema
 */
public class Controller {

    private static Controller controller;
    private final RepositoryUser repositoryUser;
    private final RepositoryManufacturer repositoryManufacturer;
    private final RepositoryProduct repositoryProduct;

    private Controller() {
        this.repositoryUser = new RepositoryUser();
        this.repositoryManufacturer = new RepositoryManufacturer();
        this.repositoryProduct = new RepositoryProduct();
    }
    
     public static Controller getInstance() {
        if (controller == null)
            controller = new Controller();
        return controller;
     }
    
    public User login(String username, String password) throws Exception {
        List<User> users = repositoryUser.getUsers();
        for (User user: users) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new Exception("Unknown user");
    }
    
    public List<Manufacturer> getAllManufacturers() {
        return repositoryManufacturer.getManufacturers();
    }
    
    public void addProduct(Product product) {
        repositoryProduct.add(product);
    }
    
    public List<Product> getAllProducts() {
        return repositoryProduct.getProducts();
    }

    public void deleteProduct(Product product) throws Exception {
        repositoryProduct.delete(product);
    }
}
