package app.models;

/**
 *
 * @author Dannyel
 */
public class Store extends Model {

    public Store() {
        super("stores", "store_id");
        
        this.fields.add("store_name");
        this.fields.add("store_phone");
        this.fields.add("store_email");
        this.fields.add("store_street");
        this.fields.add("store_city");
        this.fields.add("store_state");
        this.fields.add("store_zip_code");
    }
    
}
