package config;

/**
 *
 * @author Dannyel
 */
public class DBConfig {
    private static DBConfig instance;
    
    private static String host = "127.0.0.1";
    private static String port = "5431";
    private static String user = "postgres";
    private static String db = "BikeStore";
    private static String password = "admin";
    
    private DBConfig() {}
    
    public static DBConfig getInstance() {
        if(instance == null)
            instance = new DBConfig();

        return instance;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DBConfig.host = host;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        DBConfig.port = port;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        DBConfig.user = user;
    }

    public static String getDb() {
        return db;
    }

    public static void setDb(String db) {
        DBConfig.db = db;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBConfig.password = password;
    }
    
}
