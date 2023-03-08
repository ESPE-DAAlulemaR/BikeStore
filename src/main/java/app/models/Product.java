package app.models;

/**
 *
 * @author Dannyel
 */
public class Product extends Model {

    public Product() {
        super("products", "product_id");
        
        this.fields.add("product_name");
        this.fields.add("product_model_year");
        this.fields.add("product_list_price");

        this.relationFields.add("category_id");
        this.relationFields.add("brand_id");
    }
    
}
