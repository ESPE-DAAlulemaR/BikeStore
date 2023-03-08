package app.controllers;

import app.models.Model;
import app.models.User;
import core.EntityManager;
import core.Password;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dannyel
 */
public class UserController {
    public static ArrayList<User> index() {
        Model model = new User();
        return EntityManager.build(User.class, model.all());
    }
    
    public static User get(int id) {
        User user = new User();
        
        user.find(id);
        
        return user;
    }
    
    public static void store(String name, String lastname, String username, String email, String password) {
        Model model = new User();
        
        String hashedPassword;
        try {
            hashedPassword = Password.encrypt(password);
            
            model.name = name;
            model.lastname = lastname;
            model.username = username;
            model.email = email;
            model.password = hashedPassword;

            model.save();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void update(int id, String name, String lastname, String username, String email, String password) {
        Model model = new User();
        
        model.find(id);
        
        model.name = name;
        model.lastname = lastname;
        model.username = username;
        model.email = email;
        
        if (password != null) {
            try {
                String hashedPassword = Password.encrypt(password);
                model.password = hashedPassword;
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        model.update();
    }
    
    public static void destroy(int id) {
        Model model = new User();
        model.find(id);
        model.delete();
    }
}
