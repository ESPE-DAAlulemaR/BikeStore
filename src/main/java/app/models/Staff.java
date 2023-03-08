package app.models;

/**
 *
 * @author Dannyel
 */
public class Staff extends Model {

    public Staff() {
        super("staffs", "staff_id");
        
        this.fields.add("staff_first_name");
        this.fields.add("staff_last_name");
        this.fields.add("staff_email");
        this.fields.add("staff_phone");
        this.fields.add("staff_active");

        this.relationFields.add("store_id");
        this.relationFields.add("manager_id");
    }
    
}
