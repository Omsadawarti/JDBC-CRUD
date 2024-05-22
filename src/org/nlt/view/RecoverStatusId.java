/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nlt.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author OM
 */
public class RecoverStatusId {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testproject2023", "root" , "");
        Statement smt = con.createStatement();
        smt.execute("update persons set status = 1 where status = 0");
        System.out.println("Updated");
//        ResultSet rs = smt.executeQuery("select * from persons where status = 0");
//        rs.last();
//        int size = rs.getRow();
//        rs.beforeFirst();
//        String [][] data = new String[size][4] ;
        
        
    }
}
