package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.DBConfig;

/**
 *
 * @author Dannyel
 */
public class DBConnexion {
    private static DBConnexion connexion;
    private static Connection conn = null;
	
    private DBConnexion() {}

    public static DBConnexion getConnexion() {
        if(connexion == null)
            connexion = new DBConnexion();

        return connexion;
    }

    public Connection connect() {
        String url = "jdbc:postgresql://" + DBConfig.getHost() + ":" + DBConfig.getPort() + "/" + DBConfig.getDb();
        
        try {
            conn = DriverManager.getConnection(url, DBConfig.getUser(), DBConfig.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }

    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
