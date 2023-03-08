package app.models;

/**
 *
 * @author Dannyel
 */
public class OrderItem extends Model {

    public OrderItem() {
        super("order_items", "order_item_id");
        
        this.fields.add("order_item_quality");
        this.fields.add("order_item_list_price");
        this.fields.add("order_item_discount");

        this.relationFields.add("order_id");
        this.relationFields.add("product_id");
    }
    
}
