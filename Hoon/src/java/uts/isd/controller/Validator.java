/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

/**
 *
 * @author jaehyeokseong
 */

import jakarta.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator implements Serializable{ 
    
    private String emailPattern = ".*";      
    private String namePattern = ".*";       
    private String passwordPattern = ".*";       

    public Validator() {
        
    }       

    public boolean validate(String pattern, String input){       
       Pattern regEx = Pattern.compile(pattern);       
       Matcher match = regEx.matcher(input);       
       return match.matches(); 
    }       

    public boolean checkEmpty(String email, String password){       
       return  email.isEmpty() || password.isEmpty();   
    }

    public boolean validateEmail(String email){                       
       return validate(emailPattern,email);   
    }

    public boolean validateName(String name){
       return validate(namePattern,name); 
    }       

    public boolean validatePassword(String password){
       return validate(passwordPattern,password); 
    }          
    
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter name");
    }
}
