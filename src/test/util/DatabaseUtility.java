package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.io.*;

public class DatabaseUtility {

    private final Logger logger = LogManager.getLogger(this.getClass());

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/ASCTest?useSSL=false";
    static final String USER = "root";
    static final String PASS = "student";

    /**
     * Run the sql.
     *
     * @param sqlFile the sql file to be read and executed line by line
     */
    public void runSQL(String sqlFile) {
        Connection connection = null;
        Statement statement = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(sqlFile);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            statement = connection.createStatement();

            while (true) {
                String sql = br.readLine();
                if (sql == null) {
                    break;
                }
                statement.executeUpdate(sql);
            }
        } catch (SQLException se) {
            logger.error(sqlFile + se);
        } catch (Exception e) {
            logger.error(e);
        }
    }

}