package app.models;

/**
 *
 * @author Dannyel
 */
public class User extends Model {    
    public User() {
        super("users", "user_id");
        
        this.fields.add("name");
        this.fields.add("lastname");
        this.fields.add("username");
        this.fields.add("email");
        this.fields.add("password");
    }
}
