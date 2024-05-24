
import java.sql.SQLException;

import dao.ProductsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.PolyBayDatabase;

import models.Product;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ProductsDAO productsDAO = new ProductsDAO();
        


        for (Product product : productsDAO.findAll()) {
            System.out.println(product);
        }
        

    }
}
