package app.controllers;

import app.models.Staff;
import app.models.Model;
import core.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Dannyel
 */
public class StaffController {
    public static ArrayList<Staff> index() {
        Model model = new Staff();
        return EntityManager.build(Staff.class, model.all());
    }
    
    public static Staff get(int id) {
        Staff model = new Staff();
        
        model.find(id);
        
        return model;
    }
    
    public static void store(int store_id, int manager_id, String staff_first_name, String staff_last_name, String staff_email, String staff_phone, String staff_active) {
        Model model = new Staff();
    
        model.store_id = store_id;
        model.manager_id = manager_id;

        model.staff_first_name = staff_first_name;
        model.staff_last_name = staff_last_name;
        model.staff_email = staff_email;
        model.staff_phone = staff_phone;
        model.staff_active = staff_active;
        
        model.save();
    }
    
    public static void update(int id, int store_id, int manager_id, String staff_first_name, String staff_last_name, String staff_email, String staff_phone, String staff_active) {
        Model model = new Staff();
        
        model.find(id);

        model.store_id = store_id;
        model.manager_id = manager_id;

        model.staff_first_name = staff_first_name;
        model.staff_last_name = staff_last_name;
        model.staff_email = staff_email;
        model.staff_phone = staff_phone;
        model.staff_active = staff_active;
        
        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new Staff();

        model.find(id);
        
        model.delete();
    }
}
