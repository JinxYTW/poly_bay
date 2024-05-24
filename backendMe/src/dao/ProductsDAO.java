package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;


import database.PolyBayDatabase;
import models.Product;

public class ProductsDAO {
    

    public ProductsDAO() {
        
    }


    


    public ArrayList<Product> findAll(){
        
        
        ArrayList<Product> products = new ArrayList<Product>();
        
        try {
            PolyBayDatabase database = new PolyBayDatabase();
            PreparedStatement statement = database.prepareStatement("SELECT * FROM product");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                products.add(new Product(result.getInt("id"), result.getString("name"), result.getString("owner"), result.getFloat("bid")));
            }
        } catch (SQLException exception) {
            System.err.println("An error occurred while preparing the statement.");
        }
        return products;

    }
}

