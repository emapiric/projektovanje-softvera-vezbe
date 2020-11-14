/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository;

import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.User;

/**
 *
 * @author Ema
 */
public class RepositoryUser {
    private final List<User> users;

    public RepositoryUser() {
        this.users = new ArrayList<User>(){
            {
                add(new User(1l, "Admin", "Admin","admin","admin","admin@gmail.com"));
                add(new User(2l, "Admin2", "Admin2","admin2","admin2","admin2@gmail.com"));
                add(new User(3l, "Admin3", "Admin3","admin3","admin3","admin3@gmail.com"));
            }
        };
    }

    public List<User> getUsers() {
        return users;
    }
    
    
}
