package core;

import app.models.User;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Dannyel
 */
public class Auth {
    public static User user;
    
    public static boolean authenticate(String username, String password) throws NoSuchAlgorithmException {
        User localUser = new User();
        
        localUser.where("username", username)
                .orWhere("email", username)
                .first();
        
        if (localUser.username == null && localUser.password  == null)
            return false;
        
        boolean result = Password.verify(password, localUser.password);
        
        if (result)
            user = localUser;
        
        return result;
    }
    
    public static void unauthenticate() {
        user = null;
    }
}
