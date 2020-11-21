/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author EMA
 */
public class DBConnectionFactory {
    private Connection connection;
    private static DBConnectionFactory instance;
    
    private DBConnectionFactory() {
    }
    
    public static DBConnectionFactory getInstance() {
        if (instance == null)
            instance = new DBConnectionFactory();
        return instance;
    }
    
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String sql = "INSERT INTO product VALUES (?,?,?,?,?,?)";
            String url = "jdbc:mysql://localhost:3306/psdb";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
