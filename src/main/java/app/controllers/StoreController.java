package app.controllers;

import app.models.Store;
import app.models.Model;
import core.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Dannyel
 */
public class StoreController {
    public static ArrayList<Store> index() {
        Model model = new Store();
        return EntityManager.build(Store.class, model.all());
    }
    
    public static Store get(int id) {
        Store model = new Store();
        
        model.find(id);
        
        return model;
    }
    
    public static void store(String store_name, String store_phone, String store_email, String store_street, String store_city, String store_state, String store_zip_code) {
        Model model = new Store();
    
        model.store_name = store_name;
        model.store_phone = store_phone;
        model.store_email = store_email;
        model.store_street = store_street;
        model.store_city = store_city;
        model.store_state = store_state;
        model.store_zip_code = store_zip_code;
        
        model.save();
    }
    
    public static void update(int id, String store_name, String store_phone, String store_email, String store_street, String store_city, String store_state, String store_zip_code) {
        Model model = new Store();
        
        model.find(id);
        
        model.store_name = store_name;
        model.store_phone = store_phone;
        model.store_email = store_email;
        model.store_street = store_street;
        model.store_city = store_city;
        model.store_state = store_state;
        model.store_zip_code = store_zip_code;
        
        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new Store();

        model.find(id);
        
        model.delete();
    }
}
