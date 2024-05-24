import java.sql.SQLException;

import controllers.ProductsController;
import dao.ProductsDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.PolyBayDatabase;
import models.Product;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");
        ProductsDAO productsDAO = new ProductsDAO();
        WebServer webServer = new WebServer();
        webServer.listen(8080);

        webServer.getRouter().get("/products", 
        (WebServerContext context) -> {ProductsController.findAll(context);});
            
        for (Product product : productsDAO.findAll()) {
            System.out.println(product);
        }

        webServer.getRouter().post("/bid/:productId",
        (WebServerContext context) -> {ProductsController.bid(context);});
        

    }

}