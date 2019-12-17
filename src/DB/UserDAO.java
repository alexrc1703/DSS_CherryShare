package DB;

import APP.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> list() {
        try {

            Connection c = Connect.connect();

            List<User> res = new ArrayList<User>();

            if (c != null) {
                PreparedStatement psUser = c.prepareStatement("SELECT U.Email, U.Username, U.Password, U.isAdmin FROM User AS U;");
                ResultSet rsUser = psUser.executeQuery();

                while (rsUser.next()) {
                    User us = new User(rsUser.getString("Email"),rsUser.getString("Password"),rsUser.getString("Username"),rsUser.getBoolean("Password"));

                    res.add(us);
                }

                c.close();

                return res;
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

        return null;
    }

    public User get(String Email){
        try{

            Connection c = Connect.connect();

            if(c != null){
                                 
                PreparedStatement psUser = c.prepareStatement("SELECT U.Password, U.Username, U.isAdmin FROM User AS U WHERE U.Email=?;");
                psUser.setString(1, Email);
                ResultSet rsUser = psUser.executeQuery();

                if(rsUser.next()){
                    return (new User(Email,rsUser.getString("Password"),rsUser.getString("Username"),rsUser.getBoolean("isAdmin")));
                }

                c.close();
            }
        }
        catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }   

        return null;
    }

    public boolean containsKey(String email) {

        try {
            Connection c = Connect.connect();
            if(c != null) {
                PreparedStatement ps = c.prepareStatement("SELECT Email FROM `User` WHERE `Email`=?;");
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                return rs.next();
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

        return false;
    }

    public void put(User u) {
        try {
            Connection c = Connect.connect();
            assert c != null;
            PreparedStatement ps = c.prepareStatement("INSERT INTO User (Email, Password, Username, isAdmin) VALUES (?,?,?,?);");
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getUsername());
            ps.setBoolean(4, u.getAdmin());
            ps.executeUpdate();

            c.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }
    }

    public void remove(String key) {
        try {
            Connection c = Connect.connect();
            assert c != null;

            User u = (User)get(key);

            //delete friends
            //delete music
            //delete videos

            PreparedStatement stm1 = c.prepareStatement("Delete from User where `Email`=?");
            stm1.setString(1, key);
            stm1.executeUpdate();

            c.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void updateInfo(String email, String password, String username, boolean admin) {

        try {
            Connection c = Connect.connect();
            assert c != null;
            PreparedStatement ps = c.prepareStatement("UPDATE User SET email =?, Password=?, Username=?, isAdmin=? WHERE Email=?;");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, username);
            ps.setBoolean(4, admin);
            ps.setString(5, email);
            ps.executeUpdate();
            
            c.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }

    }
}
