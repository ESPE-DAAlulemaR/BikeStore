package app.controllers;

import app.models.VIP;
import app.models.Model;
import core.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Dannyel
 */
public class VIPController {
    public static ArrayList<VIP> index() {
        Model model = new VIP();
        return EntityManager.build(VIP.class, model.all());
    }
    
    public static VIP get(int id) {
        VIP brand = new VIP();
        
        brand.find(id);
        
        return brand;
    }
    
    public static void store(int customer_id) {
        Model model = new VIP();
        
        model.customer_id = customer_id;
        
        model.save();
    }
    
    public static void update(int id, int customer_id) {
        Model model = new VIP();
        
        model.find(id);
        
        model.customer_id = customer_id;
        
        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new VIP();

        model.find(id);
        
        model.delete();
    }
}
