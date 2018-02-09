/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ola
 */
package iEatPackage.model;

import java.sql.*;
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

    private Connection connection;
    //final String dbuser = "ieat";
    //final String dbpass = "codeislife";
    // final String dburl = "jdbc:derby://localhost:1527/ieat_users.db";
    public Connection getMysqlConnection() throws ClassNotFoundException, SQLException {
        final String dbuser = "ieat";
        final String dbpass = "codeislife";
        final String dburl = "jdbc:derby://localhost:1527/ieat_users.db";
        Class.forName("com.mysql.jdbc.Driver");
        
         connection = DriverManager.getConnection(dburl, dbuser, dbpass);
        return  connection;
    }

   

   

}
