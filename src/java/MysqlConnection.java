/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ola
 */
import java.sql.*;

public class MysqlConnection {

    public static void main(String args[]) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ieat_users.db", "ieat", "codeislife");

            Statement st = con.createStatement();
            ResultSet result;
            result = st.executeQuery("SELECT * FROM USERS ");
            if (result.next()) {
                while(result.next()){
                //System.out.println("name");
                }
            } else {
                
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
