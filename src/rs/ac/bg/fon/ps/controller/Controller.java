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
import rs.ac.bg.fon.ps.repository.Repository;
import rs.ac.bg.fon.ps.repository.RepositoryManufacturer;
import rs.ac.bg.fon.ps.repository.RepositoryProduct;
import rs.ac.bg.fon.ps.repository.RepositoryUser;
import rs.ac.bg.fon.ps.repository.db.DBRepository;
import rs.ac.bg.fon.ps.repository.db.impl.DBRepositoryManufacturer;
import rs.ac.bg.fon.ps.repository.db.impl.DBRepositoryProduct;
import rs.ac.bg.fon.ps.repository.db.impl.DBRepositoryUser;

/**
 *
 * @author Ema
 */
public class Controller {

    private static Controller controller;
    private final Repository<User> repositoryUser;
    private final Repository repositoryManufacturer;
    private final Repository repositoryProduct;

    private Controller() {
        this.repositoryUser = new DBRepositoryUser();
        this.repositoryManufacturer = new DBRepositoryManufacturer();
        this.repositoryProduct = new DBRepositoryProduct();
    }
    
     public static Controller getInstance() {
        if (controller == null)
            controller = new Controller();
        return controller;
     }
    
    public User login(String username, String password) throws Exception {
        List<User> users = repositoryUser.getAll();
        for (User user: users) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new Exception("Unknown user");
    }
    
    public List<Manufacturer> getAllManufacturers() {
        return repositoryManufacturer.getAll();
    }
    
    public void addProduct(Product product) throws Exception {
        repositoryProduct.add(product);
    }
    
    public List<Product> getAllProducts() {
        return repositoryProduct.getAll();
    }

    public void deleteProduct(Product product) throws Exception {
        //repositoryProduct.delete(product);
    }
}
