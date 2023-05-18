/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author jaehyeokseong
 */
public class Customer {
    private String name;
    private String email;
    private String password;
    private String pno;
    
    public Customer(String name, String email, String password, String pno) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.pno = pno ;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getPNO() {
        return this.pno;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setPNO(String pNo) {
        this.pno = pno;
    }
}
