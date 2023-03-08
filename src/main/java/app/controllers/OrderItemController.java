package app.controllers;

import app.models.OrderItem;
import app.models.Model;
import core.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Dannyel
 */
public class OrderItemController {
    public static ArrayList<OrderItem> index() {
        Model model = new OrderItem();
        return EntityManager.build(OrderItem.class, model.all());
    }
    
    public static OrderItem get(int id) {
        OrderItem model = new OrderItem();
        
        model.find(id);
        
        return model;
    }
    
    public static void store(int order_id, int product_id, String order_item_quality, String order_item_list_price, String order_item_discount) {
        Model model = new OrderItem();
    
        model.order_id = order_id;
        model.product_id = product_id;

        model.order_item_quality = order_item_quality;
        model.order_item_list_price = order_item_list_price;
        model.order_item_discount = order_item_discount;
        
        model.save();
    }
    
    public static void update(int id, int order_id, int product_id, String order_item_quality, String order_item_list_price, String order_item_discount) {
        Model model = new OrderItem();
        
        model.find(id);

        model.order_id = order_id;
        model.product_id = product_id;
        
        model.order_item_quality = order_item_quality;
        model.order_item_list_price = order_item_list_price;
        model.order_item_discount = order_item_discount;

        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new OrderItem();

        model.find(id);
        
        model.delete();
    }
}
