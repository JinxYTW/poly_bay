package controllers;

import java.util.ArrayList;

import models.Product;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class ProductsController {

    public static ArrayList<Product> findAll(WebServerContext context) {
        ArrayList<Product> products = new ArrayList<Product>();

        context.getResponse().ok("Tous les produits");

        
        
        return products;
    }
    
}

