package core;

import app.models.Model;
import java.lang.reflect.Field;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dannyel
 */
public abstract class AbstractModel {
    public ArrayList<String> fields = new ArrayList<>();
    public ArrayList<String> relationFields = new ArrayList<>();

    protected String table;
    protected int id;

    private String pk;

    private DBConnexion conn = DBConnexion.getConnexion();

    private boolean selecting = false;
    private boolean condition = false;
    private boolean joining = false;
    private boolean ordering = false;
    private boolean grouping = false;

    private String query;
    private String order;
    private String orderMethod;
    private String group;

    private ArrayList<String> selects = new ArrayList<>();
    private ArrayList<String> wheres = new ArrayList<>();
    private ArrayList<String> joins = new ArrayList<>();

    public AbstractModel(String table, String pk) {
        this.setTable(table);
        this.setPk(pk);
    }

    public AbstractModel() {
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<Object> all() {
        this.fields.add(this.pk);
        String sql = "SELECT * FROM " + this.getTable();
        System.out.println(sql);

        ArrayList<Object> list = new ArrayList<>();

        Statement stmt;
        ResultSet rs;

        try {
            stmt = this.conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            String className = this.getClass().getName();
            
            Class<?> daughterClass = Class.forName(className);
            
            ArrayList<Field> attrs = new ArrayList<>();
            
            for (int i = 0; i <= 1; i++) {
                attrs.addAll(Arrays.asList(daughterClass.getDeclaredFields()));
                daughterClass = daughterClass.getSuperclass();
            }
            
            daughterClass = Class.forName(className);
            
            while (rs.next()) {
                Object newInstance = daughterClass.newInstance();
                
                for (Field attr : attrs) {
                    attr.setAccessible(true);
                    String attrName = attr.getName();

                    if (attrName.equals(this.pk))
                        attr.set(newInstance, rs.getInt(this.pk));
                    else {
                        for (String field : fields)
                            if (attrName.equals(field))
                                attr.set(newInstance,
                                        (rs.getObject(field) == null) ? null : rs.getObject(field).toString());
                    }
                }

                list.add(newInstance);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.conn.disconnect();
        this.fields.remove(this.pk);
        return list;
    }

    public void find(int id) {
        this.id = id;
        String sql = "SELECT * FROM " + this.getTable() + " WHERE " + this.pk + " = " + this.id;
        System.out.println(sql);

        Statement stmt;
        ResultSet rs;

        try {
            stmt = this.conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                this.id = rs.getInt(this.pk);
                for (String field : fields) {
                    Class<?> daughterClass = this.getClass();

                    // Obtener todos los attrs declarados en la clase hija y sus superclases
                    ArrayList<Field> classAttrs = new ArrayList<>();
                    while (daughterClass != null) {
                        classAttrs.addAll(Arrays.asList(daughterClass.getDeclaredFields()));
                        daughterClass = daughterClass.getSuperclass();
                    }
                    // Buscar el f correspondiente a partir del nombre almacenado en la cadena
                    Field attr = null;
                    for (Field f : classAttrs) {
                        if (f.getName().equals(field)) {
                            attr = f;
                            break;
                        }
                    }

                    // Establecer el valor del f obtenido en el objeto de la clase hija
                    attr.setAccessible(true);
                    attr.set(this, (rs.getObject(field) == null) ? null : rs.getObject(field).toString());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.conn.disconnect();
    }

    public void first() {
        this.buildQuery();
        this.query = this.query + " LIMIT 1";
        System.out.println(this.query);

        Statement stmt;
        ResultSet rs;

        try {
            stmt = this.conn.connect().createStatement();
            rs = stmt.executeQuery(this.query);

            while (rs.next()) {
                this.id = rs.getInt(this.pk);
                for (String field : fields) {
                    Class<?> daughterClass = this.getClass();

                    // Obtener todos los attrs declarados en la clase hija y sus superclases
                    ArrayList<Field> classAttrs = new ArrayList<>();
                    while (daughterClass != null) {
                        classAttrs.addAll(Arrays.asList(daughterClass.getDeclaredFields()));
                        daughterClass = daughterClass.getSuperclass();
                    }
                    // Buscar el f correspondiente a partir del nombre almacenado en la cadena
                    Field attr = null;
                    for (Field f : classAttrs) {
                        if (f.getName().equals(field)) {
                            attr = f;
                            break;
                        }
                    }

                    // Establecer el valor del f obtenido en el objeto de la clase hija
                    attr.setAccessible(true);
                    attr.set(this, (rs.getObject(field) == null) ? null : rs.getObject(field).toString());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.conn.disconnect();
    }
    
    public ArrayList<Model> get() {
        this.buildQuery();
        System.out.println(this.query);

        ArrayList<Model> list = new ArrayList<>();

        Statement stmt;
        ResultSet rs;

        try {
            stmt = this.conn.connect().createStatement();
            rs = stmt.executeQuery(this.query);

            while (rs.next()) {
                Model newInstance = new Model();
                Field[] attrs = Model.class.getDeclaredFields();
                for (Field attr : attrs) {
                    attr.setAccessible(true);
                    String attrName = attr.getName();
                    
                    if (this.selecting) {
                        if (this.selects.contains(this.pk)) {
                            attr.set(newInstance, rs.getInt(this.pk));
                            this.selects.remove(this.pk);
                        }
                        
                        for (String select : selects)
                        {
                            int index = -1;
                            if (select.contains("AS"))
                                index = select.indexOf("AS");
                            else if (select.contains("as"))
                                index = select.indexOf("as");
                            
                            if (index != -1)
                                select = select.substring(index + 3, select.length());
                            
                            if (attrName.equals(select))
                                attr.set(newInstance, rs.getObject(select).toString());
                        }
                    } else {
                        System.out.println("else");
                        for (String field : fields)
                            if (attrName.equals(field))
                                attr.set(newInstance,
                                        (rs.getObject(field) == null) ? null : rs.getObject(field).toString());
                    }
                }
                list.add(newInstance);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.conn.disconnect();

        return list;
    }

    public AbstractModel select(String[] fields) {
        this.selecting = true;

        for (int i = 0; i < fields.length; i++)
            this.selects.add(fields[i]);

        return this;
    }

    public void save() {
        String sql = "INSERT INTO " + this.table + "(";
        String values = "(";
        int counter = 0;

        Class<?> daughterClass = this.getClass();

        // Obtener todos los attrs declarados en la clase hija y sus superclases
        ArrayList<Field> classAttrs = new ArrayList<>();
        while (daughterClass != null) {
            classAttrs.addAll(Arrays.asList(daughterClass.getDeclaredFields()));
            daughterClass = daughterClass.getSuperclass();
        }

        for (String field : fields) {
            sql += (counter == 0) ? field : ", " + field;

            try {
                // Buscar el f correspondiente a partir del nombre almacenado en la cadena
                Field attr = null;
                for (Field f : classAttrs) {
                    if (f.getName().equals(field)) {
                        attr = f;
                        break;
                    }
                }

                attr.setAccessible(true);
                Object value;

                try {
                    value = (String) attr.get(this);

                    if (value != null)
                        values += (counter == 0) ? "'" + value + "'" : ", '" + value + "'";
                    else
                        values += (counter == 0) ? "null" : ", null";

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SecurityException ex) {
                Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            counter++;
        }

        for (String field : relationFields) {
            sql += (counter == 0) ? field : ", " + field;

            try {
                Field attr = this.getClass().getDeclaredField(field);
                attr.setAccessible(true);
                Object value;
                try {
                    value = attr.get(this);

                    if (value != null)
                        values += (counter == 0) ? "'" + value + "'" : ", '" + value + "'";
                    else
                        values += (counter == 0) ? "null" : ", null";

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            counter++;
        }

        sql += ") VALUES " + values + ")";
        System.out.println(sql);

        PreparedStatement statement;
        try {
            statement = this.conn.connect().prepareStatement(sql);
            int rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted + " Filas afectadas");
            this.conn.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update() {
        String sql = "UPDATE " + this.table + " SET ";
        int counter = 0;

        Class<?> daughterClass = this.getClass();

        // Obtener todos los attrs declarados en la clase hija y sus superclases
        ArrayList<Field> classAttrs = new ArrayList<>();
        while (daughterClass != null) {
            classAttrs.addAll(Arrays.asList(daughterClass.getDeclaredFields()));
            daughterClass = daughterClass.getSuperclass();
        }

        for (String field : fields) {
            sql += (counter == 0) ? field : ", " + field;

            try {
                // Buscar el f correspondiente a partir del nombre almacenado en la cadena
                Field attr = null;
                for (Field f : classAttrs) {
                    if (f.getName().equals(field)) {
                        attr = f;
                        break;
                    }
                }

                attr.setAccessible(true);
                Object value;

                try {
                    value = (String) attr.get(this);

                    if (value != null)
                        sql += (counter == 0) ? " = '" + value + "'" : " = '" + value + "'";
                    else
                        sql += (counter == 0) ? " = null" : " = null";

                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SecurityException ex) {
                Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            counter++;
        }
        sql += " WHERE " + this.pk + " = " + this.id;
        System.out.println(sql);

        PreparedStatement statement;
        try {
            statement = this.conn.connect().prepareStatement(sql);
            int rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted + " Filas afectadas");
            this.conn.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete() {
        String sql = "DELETE FROM " + this.getTable() + " WHERE " + this.pk + " = '" + this.id + "'";
        System.out.println(sql);
        PreparedStatement stmt;
        try {
            stmt = this.conn.connect().prepareStatement(sql);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " Filas eliminadas");
            this.conn.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AbstractModel where(String field, String condition) {
        this.condition = true;

        if (this.wheres.isEmpty())
            this.wheres.add(" WHERE " + field + " = '" + condition + "'");
        else
            this.wheres.add(" AND " + field + " = '" + condition + "'");

        return this;
    }

    public AbstractModel where(String field, String operator, String condition) {
        this.condition = true;

        if (this.wheres.isEmpty())
            this.wheres.add(" WHERE " + field + " " + operator + " '" + condition + "'");
        else
            this.wheres.add(" AND " + field + " " + operator + " '" + condition + "'");

        return this;
    }

    public AbstractModel orWhere(String field, String condition) {
        this.condition = true;

        this.wheres.add(" OR " + field + " = '" + condition + "'");

        return this;
    }

    public AbstractModel orWhere(String field, String operator, String condition) {
        this.condition = true;

        this.wheres.add(" OR " + field + " " + operator + " '" + condition + "'");

        return this;
    }

    public AbstractModel join(String table, String lFields, String rFields) {
        this.joining = true;

        this.joins.add(" JOIN " + table + " ON " + lFields + " = " + rFields);

        return this;
    }

    public AbstractModel join(String table, String lFields, String rFields, String type) {
        this.joining = true;

        this.joins.add(" " + type + " JOIN " + table + " ON " + lFields + " = " + rFields);

        return this;
    }

    public AbstractModel orderBy(String field) {
        this.ordering = true;

        this.order = field;
        this.orderMethod = "ASC";

        return this;
    }

    public AbstractModel orderBy(String field, String method) {
        this.ordering = true;

        this.order = field;
        this.orderMethod = method;

        return this;
    }

    public AbstractModel groupBy(String field) {
        this.grouping = true;

        this.group = field;

        return this;
    }

    private void buildQuery() {
        this.query = "SELECT ";

        int counter = 0;

        if (this.selecting)
            for (String select : selects) {
                this.query += (counter == 0) ? select : ", " + select;
                counter++;
            }
        else
            this.query += "*";

        this.query += " FROM " + this.getTable();

        if (this.joining) {
            for (String join : joins)
                this.query += join;
        }

        if (this.condition) {
            for (String where : wheres)
                this.query += where;
        }

        if (this.grouping)
            this.query += " GROUP BY " + this.group;

        if (this.ordering)
            this.query += " ORDER BY " + this.order + " " + this.orderMethod;
    }
}
