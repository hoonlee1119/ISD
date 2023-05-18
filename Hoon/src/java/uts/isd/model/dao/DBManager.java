/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import uts.isd.model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author jaehyeokseong
 */
public class DBManager {
    
    private Statement st;
    
    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public User findU(String email, String password) throws SQLException {
         String fetch = "select * from userid.CUSTOMER where EMAIL= '" + email+ "' and PASSWORD= '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) {
            String Email = rs.getString(2);
            String Password = rs.getString(3);
            if(Email.equals(email) && Password.equals(password)) {
                String Name = rs.getString(1);
                String uPno = rs.getString(4);
                
                return new User(Name, Email, Password,uPno);
            }
        }
        
        // not found
        return null;
    }
    
    public void addU(String name, String email, String password, String pno) throws SQLException {
        st.executeUpdate("INSERT INTO userid.CUSTOMER" + " VALUES (' " + name + " ','" + email +"','" + password + "','" + pno + "')" );
    }
  
    public void updateU(String name, String email, String password, String pno) throws SQLException {
       st.executeUpdate("UPDATE  userid.CUSTOMER SET NAME='"  + name + " ',EMAIL='" + email +"',PASSWORD='" + password + "',PHONENUMBER='" + pno + "'WHERE EMAIL='" + email + "'" );       
    }
    public void addALOG(String email) throws SQLException
    {
         st.executeUpdate("INSERT INTO userid.ALOG" + " VALUES ( ' " + email + " ')" );
    }
    
    public void deleteU(String email) throws SQLException {
        st.executeUpdate("DELETE FROM userid.CUSTOMER where EMAIL= '" + email+ "'");
    }
    
    public ArrayList<User> fectU() throws SQLException {
         String fetch = "select * from userdb.CUSTOMER";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> users = new ArrayList<>();
        
        while(rs.next()) {
            String name = rs.getString(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String pno = rs.getString(4);
       
            users.add(new User(name, email, password, pno));
        }
        
        return users;
    }
    
    public boolean checkU(String email, String password) throws SQLException {
        String fetch = "select * from USERID.CUSTOMER where EMAIL='" + email + "' and password='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) {
            String Email = rs.getString(2);
            String Password = rs.getString(3);
            if(Email.equals(email) && Password.equals(password)) 
                return true;
        }
        
        return false;
    }
}
