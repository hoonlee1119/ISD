/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hoonl
 */
public class CancelRegisterServlet extends HttpServlet {

 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Perform any necessary cancellation logic here
HttpSession session = request.getSession(false);
        if (session != null) {
         session.setAttribute("registerCancel", "Cancelling Registeration for User");
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invoke the doGet method to handle the cancellation action
        doGet(request, response);
    }
}
