/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;
import java.sql.SQLException;


/**
 *
 * @author jaehyeokseong
 */
public class DeleteServlet extends HttpServlet {
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;
        DBManager manager = (DBManager)session.getAttribute("manager");
        
       
        try {
             user = manager.findU(email, password);
            if(user != null) {
                session.setAttribute("user", user);
                manager.deleteU(email);
                
                request.getRequestDispatcher("index.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the Database!");
                request.getRequestDispatcher("delete_user.jsp").include(request, response);
            }
        } catch(SQLException ex) {
            System.out.println("UpdateServlet.java 에서 SQLException 발생함");
        }
        response.sendRedirect("delete_user.jsp");
    }
}