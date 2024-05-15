
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConexionBD {
    static public  String driver="com.mysql.cj.jdbc.Driver";
    static public String url= "jdbc:mysql://127.0.0.1:3309/db_internet";
    static public  String usuario="root";
    static public String password="";
    protected Connection conn=null;
    public ConexionBD(){
        try {
            Class.forName(driver);
            try {
                conn= DriverManager.getConnection(url,usuario,password);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
