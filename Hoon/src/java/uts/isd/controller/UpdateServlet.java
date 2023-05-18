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
public class UpdateServlet extends HttpServlet {
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String pno = request.getParameter("pno");
       
        User user = new User(name, email, password, pno);
        DBManager manager = (DBManager)session.getAttribute("manager");
        
       
        try {
            if(user != null) {
                session.setAttribute("user", user);
                manager.updateU(name, email, password, pno);
                request.getRequestDispatcher("edit_user.jsp").include(request, response);
            } else {
                session.setAttribute("updated", "Updated was not successful");
                request.getRequestDispatcher("edit_user.jsp").include(request, response);
            }
        } catch(SQLException ex) {
            System.out.println("UpdateServlet.java 에서 SQLException 발생함");
        }
        response.sendRedirect("edit_user.jsp");
    }
}
