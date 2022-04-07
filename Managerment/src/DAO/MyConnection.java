/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Quoc Dat
 */
public class MyConnection {

    public MyConnection() {
    }

    public Connection getConnect() {
        Connection cn = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyGame";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, "sa", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cn;
    }

}
