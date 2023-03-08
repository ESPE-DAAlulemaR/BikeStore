package app.models;

/**
 *
 * @author Dannyel
 */
public class Brand extends Model {
    public Brand() {
        super("brands", "brand_id");
        
        this.fields.add("brand_name");
    }
}
