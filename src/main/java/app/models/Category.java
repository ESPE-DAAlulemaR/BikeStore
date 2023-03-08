package app.models;

/**
 *
 * @author Dannyel
 */
public class Category extends Model {

    public Category() {
        super("categories", "category_id");
        
        this.fields.add("category_name");
    }
    
}
