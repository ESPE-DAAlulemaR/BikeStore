package core;

import app.models.Model;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dannyel
 */
public class EntityManager {
    /*public static ArrayList<Model> build(ArrayList<Model> list) {
        ArrayList<Model> models = new ArrayList<>();
        
        for (Object obj : list) {
            Model md = (Model) obj;
            models.add(md);
        }
        
        return models;
    }*/
    
    public static <T> ArrayList<T> build(Class<T> clazz, ArrayList<Object> objects) {
        ArrayList<T> instances = new ArrayList<>();
        
        for (Object obj : objects) {
            try {
                T instance = clazz.cast(obj);
                instances.add(instance);
            } catch (ClassCastException ex) {
                System.out.println( ex.getMessage());
            }
            
        }
        
        return instances;
    }

}
