/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import uts.isd.model.User;
import uts.isd.model.dao.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author jaehyeokseong
 */
public class TestDB {
    
    private Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection connection;
    private DBManager db;
    
    public static void main(String[] args) {
        (new TestDB()).runQueries();
    }
    
    public TestDB() {
        try {
            connector = new DBConnector();
            connection = connector.openConnection();
            db = new DBManager(connection);
        } catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice() {
        System.out.println("CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() {
        char c;
        
        while((c = readChoice()) != '*') {
            switch (c) {
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                case 'S':
                    showAll();
                    break;
                default:
                    System.out.println("Unkown Command");
                    break;
            }
        }
        
        // close connection
        try {
            connector.closeConnection();
        } catch(SQLException ex) {
            System.out.println("session is not closed");
        }
    }
    
    private void testAdd() {
        System.out.println(" name: ");
        String name = in.nextLine();
        
        System.out.println("S email: ");
        String email = in.nextLine();
        
        System.out.println("password: ");
        String password = in.nextLine();
        
        System.out.println("phonenumber: ");
        String pno = in.nextLine();
        
        try {
            db.addU(name, email, password, pno);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("student is added to the database");
    }
    
    private void testRead() {
        System.out.println(" email: ");
        String email = in.nextLine();
        
        System.out.println("password: ");
        String password = in.nextLine();
        
        User user = null;
        try {
            user = db.findU(email, password);
        } catch(SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(user != null) {
            System.out.println("Student " + user.getName() + " exist in the database.");
            System.out.println(user.getName()+ user.getEmail() + user.getPassword() + user.getPNO());
        } else {
            System.out.println("Student does not exist.");
        }
    }
    
    private void testUpdate() {
        System.out.println("Student email: ");
        String email = in.nextLine();
        
        System.out.println("Student password: ");
        String password = in.nextLine();
        
        try {
            if(db.checkU(email, password)) {
                
                System.out.println("[NEW] Student name: ");
                String name = in.nextLine();
                System.out.println("[NEW] Student dob: ");
                String pno= in.nextLine();
                db.updateU(name, email, password, pno);
            } else {
                System.out.println("Student does not exist.");
            }
        } catch(SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete() {
        System.out.println("Student email: ");
        String email = in.nextLine();
        
        try {
            db.deleteU(email);
        } catch(SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showAll() {
        ArrayList<User> users = new ArrayList<User>();
        
        try {
            users = db.fectU();
        } catch(SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(User user : users) {
            System.out.println("================================");
            System.out.println("name: " + user.getName());
            System.out.println("email: " + user.getEmail());
            System.out.println("password: " + user.getPassword());
            System.out.println("dob: " + user.getPNO());
        }
        if(!users.isEmpty()) 
            System.out.println("================================");
    }
}
