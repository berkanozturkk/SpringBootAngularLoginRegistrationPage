package securedlogin.service;

import org.springframework.stereotype.Service;
import securedlogin.dbcon.Dbconnection;
import securedlogin.repo.UserRepo;

import java.sql.*;

@Service
public class UserService implements UserRepo {

    Connection connection;

    int flag = 0;

    public UserService() throws SQLException {
        connection = Dbconnection.getConnection();
    }

    @Override
    public int logincheck(String username, String password) {
        int flag = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();



            if (rs.next()) {

                flag = 1;
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
    }

    @Override
    public int registcheck(String username, String email, String password) {

        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
            stmt.setString(1,username);
            stmt.setString(2,email);
            stmt.setString(3,password);
            int flag = stmt.executeUpdate();

            if (flag == 1) {
                System.out.println("Registration successful!");
            } else {
                System.out.println("Please fill all areas with appropriate informations!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
    }
}
