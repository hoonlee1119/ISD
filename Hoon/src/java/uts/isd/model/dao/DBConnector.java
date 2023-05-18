/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jaehyeokseong
 */
public class DBConnector extends DB {
    public DBConnector() throws ClassNotFoundException, SQLException {
//        try {
//            Class.forName(driver);
//        } catch(ClassNotFoundException ex) {
//            System.out.println("not working");
//        }
        // Class.forName(driver);
        conn = DriverManager.getConnection(URL + db, dbuser, dbpass);
    }
    
    public Connection openConnection() {
        return this.conn;
    }
    
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
