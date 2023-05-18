 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;
import uts.isd.model.*;

/**
 *
 * @author jaehyeokseong
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager)session.getAttribute("manager");
        User user = null;
        validator.clear(session);
        

               if (!validator.validateEmail(email))
        {
            session.setAttribute("emailErr ", "Error: Email Format Incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        else if (!validator.validatePassword(password))
        {
            session.setAttribute("passwordErr ", "Error: Password Format Incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        else 
        {
            try {
                user = manager.findU(email, password);
                if(user != null )
                {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("redirect.jsp").include(request, response);
                }
                else 
                {
                     session.setAttribute("existErr", "User does not exist..");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            }catch (SQLException | NullPointerException ex) {
                  System.out.println(ex.getMessage() == null ? "User does not exist" : "Welcome");}
        }
     }
     }

