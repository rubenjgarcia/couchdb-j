package org.apache.couchdb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        try {
            Class.forName("org.apache.couchdb.jdbc.CouchDriver");
            Connection con = DriverManager.getConnection("jdbc:couchdb://127.0.0.1:5984");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("/test/Users/");
            rs.updateString("teste", "Editando propriedades via JDBC");
            System.out.println(rs.getString("name"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}