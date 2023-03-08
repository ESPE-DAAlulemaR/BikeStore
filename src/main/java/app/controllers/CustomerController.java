package app.controllers;

import app.models.Customer;
import app.models.Model;
import core.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Dannyel
 */
public class CustomerController {
    public static ArrayList<Customer> index() {
        Model model = new Customer();
        return EntityManager.build(Customer.class, model.all());
    }
    
    public static Customer get(int id) {
        Customer model = new Customer();
        
        model.find(id);
        
        return model;
    }
    
    public static void store(String customer_first_name, String customer_last_name, String customer_phone, String customer_email, String customer_street, String customer_city, String customer_state, String customer_zip_code) {
        Model model = new Customer();
    
        model.customer_first_name = customer_first_name;
        model.customer_last_name = customer_last_name;
        model.customer_phone = customer_phone;
        model.customer_email = customer_email;
        model.customer_street = customer_street;
        model.customer_city = customer_city;
        model.customer_state = customer_state;
        model.customer_zip_code = customer_zip_code;
        
        model.save();
    }
    
    public static void update(int id, String customer_first_name, String customer_last_name, String customer_phone, String customer_email, String customer_street, String customer_city, String customer_state, String customer_zip_code) {
        Model model = new Customer();
        
        model.find(id);
        
        model.customer_first_name = customer_first_name;
        model.customer_last_name = customer_last_name;
        model.customer_phone = customer_phone;
        model.customer_email = customer_email;
        model.customer_street = customer_street;
        model.customer_city = customer_city;
        model.customer_state = customer_state;
        model.customer_zip_code = customer_zip_code;
        
        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new Customer();

        model.find(id);
        
        model.delete();
    }
}
