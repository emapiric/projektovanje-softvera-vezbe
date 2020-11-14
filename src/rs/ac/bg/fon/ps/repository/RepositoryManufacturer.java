/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository;

import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.Manufacturer;

/**
 *
 * @author Ema
 */
public class RepositoryManufacturer {
    private List<Manufacturer> manufacturers;

    public RepositoryManufacturer() {
        manufacturers = new ArrayList<Manufacturer>() {
            {
                add(new Manufacturer(1l, "Manufacturer - 1"));
                add(new Manufacturer(2l, "Manufacturer - 2"));
                add(new Manufacturer(3l, "Manufacturer - 3"));
                add(new Manufacturer(4l, "Manufacturer - 4"));
            }
        };
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }
    
}
