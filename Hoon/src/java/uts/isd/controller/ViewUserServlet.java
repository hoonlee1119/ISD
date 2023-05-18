/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import uts.isd.model.User;
import uts.isd.model.dao.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jaehyeokseong
 */
public class ViewUserServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String email= request.getParameter("email");
        String password = request.getParameter("password");
        String pno = request.getParameter("pno");
        DBManager manager = (DBManager)session.getAttribute("manager");
         User user = null;
        
try {
            user = manager.findU(email, password);
            if(user != null) {
                session.setAttribute("user", user);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the Database");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        } catch(SQLException ex) {
            System.out.println("EditServlet.java에서 SQLException 발생함");
        }
        
        request.getRequestDispatcher("edit.jsp").include(request, response);
    }
}