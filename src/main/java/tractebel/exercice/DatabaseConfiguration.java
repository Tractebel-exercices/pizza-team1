package tractebel.exercice;

/**
 * @author Tractebel - PSC
 */
public class DatabaseConfiguration {

    private String driver;
    private String dbName;
    private String userName;
    private String password;
    private String hostname;
    private String port;
    private String jdbcUrl;

    public DatabaseConfiguration(String driver, String dbName, String userName, String password, String hostname, String port, String jdbcUrl) {
        this.driver = driver;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.hostname = hostname;
        this.port = port;
        this.jdbcUrl = jdbcUrl;
    }

    public String getDriver() {
        return driver;
    }

    public String getDbName() {
        return dbName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getHostname() {
        return hostname;
    }

    public String getPort() {
        return port;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
