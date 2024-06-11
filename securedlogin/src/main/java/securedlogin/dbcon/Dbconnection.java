package securedlogin.dbcon;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if(connection!=null){
            return connection;
        }
        else{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/userdb";
            String user = "root";
            String password = "admin123.";

            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,password);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }
}
