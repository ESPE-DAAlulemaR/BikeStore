package app.controllers;

import app.models.Product;
import app.models.Model;
import core.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Dannyel
 */
public class ProductController {
    public static ArrayList<Product> index() {
        Model model = new Product();
        return EntityManager.build(Product.class, model.all());
    }
    
    public static Product get(int id) {
        Product model = new Product();
        
        model.find(id);
        
        return model;
    }
    
    public static void store(int category_id, int brand_id, String product_name, String product_model_year, String product_list_price) {
        Model model = new Product();
    
        model.category_id = category_id;
        model.brand_id = brand_id;

        model.product_name = product_name;
        model.product_model_year = product_model_year;
        model.product_list_price = product_list_price;
        
        model.save();
    }
    
    public static void update(int id, int category_id, int brand_id, String product_name, String product_model_year, String product_list_price) {
        Model model = new Product();
        
        model.find(id);

        model.category_id = category_id;
        model.brand_id = brand_id;

        model.product_name = product_name;
        model.product_model_year = product_model_year;
        model.product_list_price = product_list_price;

        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new Product();

        model.find(id);
        
        model.delete();
    }
    
    public static ArrayList<Model> getStock() {
        Model model = new Product();
        String[] fields = { "product_name", "stock_quality", "store_name" };
        return model.select(fields)
                .join("stocks", "products.product_id", "stocks.product_id")
                .join("stores", "stocks.store_id", "stores.store_id")
                .get();
    }
}
