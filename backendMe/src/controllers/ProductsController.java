package controllers;

import java.util.ArrayList;

import dao.ProductsDAO;
import models.Product;
import webserver.WebServerContext;
import webserver.WebServerResponse;


public class ProductsController {
    private static ProductsDAO productsDAO = new ProductsDAO();

    public static ArrayList<Product> findAll(WebServerContext context) {
        ArrayList<Product> products = productsDAO.findAll();

        context.getResponse().json(products);

        
        
        return products;
    }
    public static void bid(WebServerContext context) {
        int productId = Integer.parseInt(context.getRequest().getParam("productId"));
        ProductsDAO productsDAO = new ProductsDAO();
        float newBid = productsDAO.bid(productId);

    
        Product jsonResponse = new Product(productId, "", "", newBid);
        context.getResponse().json(jsonResponse);
    }

    

    
    
}

