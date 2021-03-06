/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller.view.form.component.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Manufacturer;
import rs.ac.bg.fon.ps.domain.Product;

/**
 *
 * @author EMA
 */
public class ProductTableModel extends AbstractTableModel{

    private final List<Product> products;
    private String[] columnNames = {"ID","Name","Description","Manufacturer","Unit","Price"};

    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    @Override
    public String getColumnName(int column) {
        if (column>columnNames.length)
            return "n/a";
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch(columnIndex) {
            case 1: 
                product.setName(value.toString());
                break;
            case 3:
                product.setManufacturer((Manufacturer) value);
            default:
                break;
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex==1 || columnIndex==3);
    }
    
    @Override
    public int getRowCount() {
        if (products == null) 
            return 0;
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch(columnIndex) {
            case 0: return product.getId();
            case 1: return product.getName();
            case 2: return product.getDescription();
            case 3: return product.getManufacturer();
            case 4: return product.getMeasurementUnit();
            case 5: return product.getPrice();
            default: return "n/a";
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        //fireTableDataChanged();
        fireTableRowsInserted(products.size()-1, products.size()-1);
    }

    public Product getProductAt(int row) {
       return products.get(row);
    }
    
}
