package app.models;

/**
 *
 * @author Dannyel
 */
public class Order extends Model {

    public Order() {
        super("orders", "order_id");

        this.fields.add("order_status");
        this.fields.add("order_date");
        this.fields.add("order_required_date");
        this.fields.add("order_shipped_date");
        
        this.relationFields.add("customer_id");
        this.relationFields.add("staff_id");
        this.relationFields.add("store_id");
    }
    
}
