package app.controllers;

import app.models.Order;
import app.models.Model;
import core.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Dannyel
 */
public class OrderController {
    public static ArrayList<Order> index() {
        Model model = new Order();
        return EntityManager.build(Order.class, model.all());
    }
    
    public static Order get(int id) {
        Order model = new Order();
        
        model.find(id);
        
        return model;
    }
    
    public static void store(int customer_id, int staff_id, int store_id, String order_status, String order_date, String order_required_date, String order_shipped_date) {
        Model model = new Order();
    
        model.customer_id = customer_id;
        model.staff_id = staff_id;
        model.store_id = store_id;

        model.order_status = order_status;
        model.order_date = order_date;
        model.order_required_date = order_required_date;
        model.customer_email = order_shipped_date;
        
        model.save();
    }
    
    public static void update(int id, int customer_id, int staff_id, int store_id, String order_status, String order_date, String order_required_date, String order_shipped_date) {
        Model model = new Order();
        
        model.find(id);

        model.customer_id = customer_id;
        model.staff_id = staff_id;
        model.store_id = store_id;
        
        model.order_status = order_status;
        model.order_date = order_date;
        model.order_required_date = order_required_date;
        model.customer_email = order_shipped_date;

        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new Order();

        model.find(id);
        
        model.delete();
    }
}
