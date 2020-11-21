/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository.db.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Manufacturer;
import rs.ac.bg.fon.ps.domain.MeasurementUnit;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.domain.User;
import rs.ac.bg.fon.ps.repository.db.DBConnectionFactory;
import rs.ac.bg.fon.ps.repository.db.DBRepository;

/**
 *
 * @author EMA
 */
public class DBRepositoryProduct implements DBRepository<Product>{

    @Override
    public List<Product> getAll() {
        try {
            String sql = "SELECT p.id as id, p.name as name, p.description, p.price, " 
                    +"p.measurementunit, m.id as mid, m.name as mname FROM product p "+
                    "INNER JOIN manufacturer m ON (p.manufacturerid = m.id)";
            List<Product> products = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setMeasurementUnit(MeasurementUnit.valueOf(rs.getString("measurementunit")));
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setId(rs.getLong("mid"));
                manufacturer.setName(rs.getString("mname"));
                product.setManufacturer(manufacturer);
                products.add(product);
            }
            rs.close();
            statement.close();
            return products;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
       
    }

    @Override
    public void add(Product product) throws Exception {
        try {
            String sql = "INSERT INTO product VALUES (?,?,?,?,?,?)";
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, product.getId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setBigDecimal(4, product.getPrice());
            statement.setLong(5, product.getManufacturer().getId());
            statement.setString(6, product.getMeasurementUnit().toString());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Product can't be saved");
        }
    }
    
}
