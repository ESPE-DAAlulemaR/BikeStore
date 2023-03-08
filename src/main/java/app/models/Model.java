package app.models;

import core.AbstractModel;

/**
 *
 * @author Dannyel
 */
public class Model extends AbstractModel {
    public Model() {
        super();
    }
    
    public Model(String table, String pk) {
        super(table, pk);
    }
    
    //PK's
    public int brand_id;
    public int category_id;
    public int customer_id;
    public int manager_id;
    public int order_id;
    public int order_item_id;
    public int product_id;
    public int staff_id;
    public int store_id;
    public int user_id;
    public int vip_id;
    
    // Brands
    public String brand_name;
    
    // Categories
    public String category_name;
    
    // Customers
    public String customer_first_name, customer_last_name, customer_phone, customer_email, customer_street, customer_city, customer_state, customer_zip_code;
    
    // Orders
    public String order_status, order_date, order_required_date, order_shipped_date;
    
    // Order_items
    public String order_item_quality, order_item_list_price, order_item_discount;
    
    // Products
    public String product_name, product_model_year, product_list_price;
    
    // Staffs
    public String staff_first_name, staff_last_name, staff_email, staff_phone, staff_active;
    
    // Stock
    public String stock_quality;
    
    // Stores
    public String store_name, store_phone, store_email, store_street, store_city, store_state, store_zip_code;
    
    // Users
    public String name, lastname, username, email, password;
    
    // Consultas 
    public String total, staff_name;
}
