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

    public void bid(int id){
        try {
            PolyBayDatabase database = new PolyBayDatabase();
            PreparedStatement getStatement = database.prepareStatement("SELECT * FROM product WHERE id = ?");
            getStatement.setInt(1, id);
            ResultSet result = getStatement.executeQuery();

            float currentBid = 0;
            while(result.next()){
                currentBid = result.getFloat("bid");
            }
    
            
            float newBid = currentBid + 50;
    
            
            PreparedStatement updateStatement = database.prepareStatement("UPDATE product SET bid = ? WHERE id = ?");
            updateStatement.setFloat(1, newBid);
            updateStatement.setInt(2, id);

            updateStatement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("An error occurred while preparing the statement.");
        }
}
}

