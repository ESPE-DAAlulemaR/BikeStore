package app.models;

/**
 *
 * @author Dannyel
 */
public class VIP extends Model {

    public VIP() {
        super("vip_customers", "vip_id");
        
        this.relationFields.add("customer_id");
    }
    
}
