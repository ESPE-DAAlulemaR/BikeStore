package app.controllers;

import app.models.Category;
import app.models.Model;
import core.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Dannyel
 */
public class CategoryController {
    public static ArrayList<Category> index() {
        Model model = new Category();
        return EntityManager.build(Category.class, model.all());
    }
    
    public static Category get(int id) {
        Category category = new Category();
        
        category.find(id);
        
        return category;
    }
    
    public static void store(String category_name) {
        Model model = new Category();
        
        model.name = category_name;
        
        model.save();
    }
    
    public static void update(int id, String category_name) {
        Model model = new Category();
        
        model.find(id);
        
        model.name = category_name;
        
        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new Category();

        model.find(id);
        
        model.delete();
    }
}
