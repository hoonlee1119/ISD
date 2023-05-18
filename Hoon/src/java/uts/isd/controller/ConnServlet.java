
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

/**
 *
 * @author jaehyeokseong
 */

import uts.isd.model.dao.DBConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.isd.model.dao.*; 

public class ConnServlet extends HttpServlet {
    
    private DBConnector db;
    private DBManager manager;
    private Connection conn;
    
    @Override
    public void init() {
        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn = db.openConnection();
        
        try {
            manager = new DBManager(conn);
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        session.setAttribute("manager", manager);
    }
    
    @Override
    public void destroy() {
        try {
            db.closeConnection();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

