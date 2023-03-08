package app.models;

/**
 *
 * @author Dannyel
 */
public class Customer extends Model {

    public Customer() {
        super("customers", "customer_id");
        
        this.fields.add("customer_first_name");
        this.fields.add("customer_last_name");
        this.fields.add("customer_phone");
        this.fields.add("customer_email");
        this.fields.add("customer_street");
        this.fields.add("customer_city");
        this.fields.add("customer_state");
        this.fields.add("customer_zip_code");
    }
    
}
