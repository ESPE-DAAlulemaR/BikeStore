package app.controllers;

import app.models.Brand;
import app.models.Model;
import core.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Dannyel
 */
public class BrandController {
    public static ArrayList<Brand> index() {
        Model model = new Brand();
        return EntityManager.build(Brand.class, model.all());
    }
    
    public static Brand get(int id) {
        Brand brand = new Brand();
        
        brand.find(id);
        
        return brand;
    }
    
    public static void store(String brand_name) {
        Model model = new Brand();
        
        model.brand_name = brand_name;
        
        model.save();
    }
    
    public static void update(int id, String brand_name) {
        Model model = new Brand();
        
        model.find(id);
        
        model.brand_name = brand_name;
        
        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new Brand();

        model.find(id);
        
        model.delete();
    }
}
