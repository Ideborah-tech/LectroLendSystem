/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author User
 */
public class UserDao {
     //JDBC properties
    private String jdbcUrl="jdbc:postgresql://localhost:5432/auca_equipment_booking_system_db";
    private String dbUser="postgres";
    private String dbPassword="12345";
    
    //CRUD operations
    
    public Integer addUser(User userObj){
        try{
            Connection con=DriverManager.getConnection(jdbcUrl,dbUser, dbPassword);
            String sql="INSERT INTO users(username,password,full_name,phone_number,role) VALUES (?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(1,userObj.getUsername());
                pst.setString(2,userObj.getPassword());
                pst.setString(3,userObj.getFullName());
                pst.setString(5,userObj.getRole());
                pst.setString(4,userObj.getPhoneNumber());
                
                int rowsAffected=pst.executeUpdate();
                con.close();
                return rowsAffected;
        }   
        catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }
    public Integer updateUser(User userObj,String userName){
        try{
            Connection con=DriverManager.getConnection(jdbcUrl,dbUser, dbPassword);
            String sql="UPDATE users SET password=?,full_name=?,phone_number=?,role=? WHERE username=?";
            PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(5,userObj.getUsername());
                pst.setString(1,userObj.getPassword());
                pst.setString(2,userObj.getFullName());
                pst.setString(4,userObj.getRole());
                pst.setString(3,userObj.getPhoneNumber());
                
               int rowsAffected=pst.executeUpdate();
                con.close();
                return rowsAffected;
                   
        }
        catch(Exception ex){
            ex.printStackTrace();
             return null;
        }
    }
    public int deleteUser(String userName){
        try{
            Connection con=DriverManager.getConnection(jdbcUrl,dbUser,dbPassword);
            String sql="DELETE FROM users WHERE username=?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, userName);
             int rowsAffected=pst.executeUpdate();
            con.close();
            return rowsAffected;
        }
        catch(Exception ex){
            ex.printStackTrace();
             return 0;
        }
    }
    
    public User searchUser(User userObj){
         
    try {
        Connection con = DriverManager.getConnection(jdbcUrl,dbUser,dbPassword);
        String sql = "SELECT * FROM users WHERE username=?";
         PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, userObj.getUsername());
        ResultSet rs = ps.executeQuery();
  User theUser = new User();
        if (rs.next()) {
          
            theUser.setUsername(rs.getString("username"));
            theUser.setFullName(rs.getString("full_name"));
            theUser.setPassword(rs.getString("password"));
            theUser.setPhoneNumber(rs.getString("phone_number"));
            theUser.setRole(rs.getString("role")); 
        }
        con.close();
        return theUser;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    }
      public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    String sql = "SELECT * FROM users";
    try {
         Connection con = DriverManager.getConnection(jdbcUrl,dbUser,dbPassword);
          PreparedStatement pst = con.prepareStatement(sql);

         ResultSet rs = pst.executeQuery(sql);
        
        while (rs.next()) {
         User theUser = new User();
             theUser.setUsername(rs.getString("username"));
            theUser.setFullName(rs.getString("full_name"));
            theUser.setPassword(rs.getString("password"));
            theUser.setPhoneNumber(rs.getString("phone_number"));
            theUser.setRole(rs.getString("role")); 
            users.add(theUser);
        }
        con.close();
        return users; 
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    
}
}

