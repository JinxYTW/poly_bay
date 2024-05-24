import java.sql.SQLException;
import dao.ProductsDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.PolyBayDatabase;
import models.Product;
import webserver.WebServer;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ProductsDAO productsDAO = new ProductsDAO();
        WebServer webServer = new WebServer();
        webServer.listen(8080);
        


        for (Product product : productsDAO.findAll()) {
            System.out.println(product);
        }
        

    }
}
